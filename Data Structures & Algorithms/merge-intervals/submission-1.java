class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int i = 0;
        List<int[]> res = new ArrayList<>();
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length && intervals[i][0] <= end) {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
                i++;
            }
            res.add(new int[] {start, end});
        }

        return res.toArray(new int[res.size()][]);
    }
}
