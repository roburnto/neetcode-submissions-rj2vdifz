class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        for (int num : piles) {
            r = Math.max(r, num);
        }

        while (l < r) {
            int rate = l + (r - l) / 2;
            if (canEat(piles, rate, h)) {
                r = rate;
            } else {
                l = rate + 1;
            }
        }
        return l + (r - l) / 2;
    }
    private boolean canEat(int[] piles, int rate, int maxHours) {
        int time = 0;
        for (int pile : piles) {
            time += (int) Math.ceil((double) pile / rate);
            if (time > maxHours) {
                return false;
            }
        }
        return true;
    }
}
