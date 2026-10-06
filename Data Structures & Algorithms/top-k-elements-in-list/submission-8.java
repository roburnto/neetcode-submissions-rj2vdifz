class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int num : counts.keySet()) {
            int frequency = counts.get(num);
            buckets.get(frequency).add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int frequency = nums.length; frequency >= 1; frequency--) {
            for (int num : buckets.get(frequency)) {
                result[index] = num;
                index++;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
