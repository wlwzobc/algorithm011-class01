class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> retList = new ArrayList<>();
        retList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curInterval = intervals[i];
            int[] lastArr = retList.get(retList.size() - 1);
            if (curInterval[0] > lastArr[1]) {
                retList.add(curInterval);
            } else {
                lastArr[1] = Math.max(curInterval[1], lastArr[1]);
            }
        }
        return retList.toArray(new int[retList.size()][]);
    }
}