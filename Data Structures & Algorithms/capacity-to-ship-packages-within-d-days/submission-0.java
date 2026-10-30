class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = weights[0];
        int r = weights[0];

        for (int i = 1; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }

        while (l < r) {
            int m = l + (r - l) / 2;
            if (canDeliver(weights, m, days)) {
                r = m;

            } else {
                l = m + 1;
            }
        }
        return r;
    }
    private boolean canDeliver(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                daysNeeded++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return daysNeeded <= days;
    }
}