class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            int currCount = 1 + count.getOrDefault(num, 0);
            count.put(num, currCount);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }
        int i = 0;
        for (int freq = nums.length; freq >= 0; freq--) {
            if (i >= k) {
                break;
            }
            if (buckets[freq] != null) {
                for (int num : buckets[freq]) {
                    if (i < k) {
                        res[i++] = num;
                    }
                }
            }
        }
        return res;
    }
}
