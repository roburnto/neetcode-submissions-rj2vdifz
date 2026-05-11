class Solution {
   public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> maxHeap(stones.begin(), stones.end());

        while (maxHeap.size() > 1) {
            int y = maxHeap.top();
            maxHeap.pop();
            int x = maxHeap.top();
            maxHeap.pop();
            int smash = y - x;
            if (smash > 0) {
                maxHeap.push(smash);
            }
        }
        return maxHeap.size() == 0 ? 0 : maxHeap.top();
    }
};
