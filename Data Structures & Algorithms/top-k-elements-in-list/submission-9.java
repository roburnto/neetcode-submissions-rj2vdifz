class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            int count = 1 + freqMap.getOrDefault(num, 0);
            freqMap.put(num, count);
        }

        List<Integer>[] buckets = new List[nums.length + 1]; // index = frequency, 0..n

        for (Map.Entry<Integer, Integer> e : freqMap.entrySet()) {
            int num = e.getKey();
            int count = e.getValue();
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }

        int count = 0;
        for (int i = nums.length; i >= 1; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    res[count++] = num;
                    if (count == k) {
                        return res;
                    }
                }
            }
        }
        return res;
    }
}