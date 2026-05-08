class Solution {
   public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int r = *max_element(piles.begin(), piles.end());
        int l = 1;
        int m;
        while (l < r) {
            m = l + (r - l) / 2;
            if (canKokoEat(m, piles, h)) {
                r = m;

            } else {
                l = m + 1;
            }
        }
        return l;
    }
    bool canKokoEat(int k, vector<int>& piles, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
            if (time > h) {
                return false;
            }
        }
        return time <= h;
    }
};
