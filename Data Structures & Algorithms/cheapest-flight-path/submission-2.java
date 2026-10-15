class Solution {
    private Map<Integer, List<int[]>> map = new HashMap<>();
    private Integer[][] cache;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // O(nk) time/space - cache city and flights remaining
        cache = new Integer[n][k + 2];

        // O(E) time/space - build adjacency list
        for (int i = 0; i < flights.length; i++) {
            if (!map.containsKey(flights[i][0])) {
                map.put(flights[i][0], new ArrayList<>());
            }
            map.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]});
        }

        // O(Ek) time - explore each (city, flightsLeft) state once
        int ans = dfs(src, dst, k + 1);

        // O(1) time - return -1 if destination is unreachable
        return ans >= (int) 1e9 ? -1 : ans;
    }

    public int dfs(int src, int dst, int stopsLeft) {
        // O(1) - destination reached
        if (src == dst) {
            return 0;
        }

        // O(1) - no flights remaining
        if (stopsLeft == 0) {
            return (int) 1e9;
        }

        // O(1) - return previously computed state
        if (cache[src][stopsLeft] != null) {
            return cache[src][stopsLeft];
        }

        // O(outdegree(src)) - explore outgoing flights
        int min = (int) 1e9;
        for (int[] next : map.getOrDefault(src, Collections.emptyList())) {
            min = Math.min(min, next[1] + dfs(next[0], dst, stopsLeft - 1));
        }

        // O(1) - cache and return result
        return cache[src][stopsLeft] = min;
    }
}

// Overall Time:  O(nk + Ek) = O(k(n + E))
// Overall Space: O(nk + E)     // cache + adjacency list + O(k) recursion stack