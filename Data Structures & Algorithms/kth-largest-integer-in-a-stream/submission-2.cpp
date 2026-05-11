class KthLargest {
   public:
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int maxSize;
    KthLargest(int k, vector<int>& nums) {
        maxSize = k;
        for (int num : nums) {
            minHeap.push(num);
            if (minHeap.size() > maxSize) {
                minHeap.pop();
            }
        }
    }

    int add(int val) {
        minHeap.push(val);
        if(minHeap.size() > maxSize){
            minHeap.pop();
        }
        return minHeap.top();
    }
};
