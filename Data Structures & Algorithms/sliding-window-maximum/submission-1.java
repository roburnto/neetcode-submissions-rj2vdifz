class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>(); // Store indices in decreasing order of their values
        int l = 0, r = 0; // Left and right boundaries of the sliding window

        while (r < n) {
            // Remove smaller values since nums[r] makes them useless for future maximums
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }

            q.addLast(r); // Add the current index to the deque

            // Remove the front index if it has fallen outside the current window
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // Once the window reaches size k, record its maximum and move left forward
            if ((r + 1) >= k) {
                res[l] = nums[q.getFirst()];
                l++;
            }

            r++; // Expand the window to the right
        }

        return res;
    }
}