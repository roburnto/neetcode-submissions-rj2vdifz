class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = post[n - 1] = 1;
        int prod = 1;
        for (int i = 1; i < n; i++) {
            prod *= nums[i - 1];
            pre[i] = prod;
        }
        prod = 1;
        for (int i = n - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            post[i] = prod;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}
