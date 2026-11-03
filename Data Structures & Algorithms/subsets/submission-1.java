class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        backtrack(0, nums, res, curSet);
        return res;
    }
    private void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> curSet) {
        if (i == nums.length) {
            res.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]);
        backtrack(i + 1, nums, res, curSet);
        curSet.removeLast();
        backtrack(i + 1, nums, res, curSet);
    }
}
