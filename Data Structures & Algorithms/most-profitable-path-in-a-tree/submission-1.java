class Solution {
    private List<Integer>[] adj;
    private int[] parent;
    private int[] bobTime;
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        // Constructing the adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        // bob simulation
        buildParents(n);
        findBobPath(bob, n);
        // alice simulation
        aliceBfs(amount);
        return maxIncome;
    }

    // BFS from 0: parent[child] = node we reached it from
    private void buildParents(int n) {
        parent = new int[n];
        Arrays.fill(parent, -2); // -2 = unvisited
        parent[0] = -1; // root has no parent; also ends Bob's walk

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int src = queue.poll();

            for (int nei : adj[src]) {
                if (parent[nei] != -2) { // already visited (includes src's own parent)
                    continue;
                }

                parent[nei] = src;
                queue.offer(nei);
            }
        }
    }

    // Walk bob -> 0 via parent pointers, stamping times 0, 1, 2, ...
    private void findBobPath(int bob, int n) {
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE); // Bob never arrives

        int time = 0;
        for (int node = bob; node != -1; node = parent[node]) {
            bobTime[node] = time++;
        }
    }

    private void aliceBfs(int[] amount) {
        // state = {src, time, income}  (income BEFORE collecting at src)
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, 0, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int src = state[0], time = state[1], income = state[2];

            // 1. Calculate what Alice gets at THIS node
            if (time < bobTime[src]) {
                income += amount[src];
            } else if (time == bobTime[src]) {
                income += amount[src] / 2;
            }

            // 2. Now check if Alice reached a leaf
            if (src != 0 && adj[src].size() == 1) {
                maxIncome = Math.max(maxIncome, income);
                continue;
            }

            // 3. Otherwise continue toward leaves
            for (int nei : adj[src]) {
                if (nei == parent[src]) { // don't walk back up
                    continue;
                }

                queue.offer(new int[] {nei, time + 1, income});
            }
        }
    }
}