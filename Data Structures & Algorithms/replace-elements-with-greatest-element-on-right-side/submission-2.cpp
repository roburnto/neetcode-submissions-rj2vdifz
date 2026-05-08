class Solution {
   public:
    vector<int> replaceElements(vector<int>& arr) {
        int r = arr.size() - 1;
        int l = r - 1;
        int maxRight = arr[r];
        while (l >= 0) {
            maxRight = max(arr[l], arr[r]);
            arr[l] = arr[r];
            l--;
            arr[r] = maxRight;
        }
        arr[r] = -1;
        return arr;
    }
};