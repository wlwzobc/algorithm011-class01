class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 使用桶排序
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现的次数作为下标
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        int[] retArr = new int[k];
        int j = 0;
        // 倒序遍历数组获取出现顺序从大到小的排列
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] != null && !list[i].isEmpty()) {
                for (Integer integer : list[i]) {
                    retArr[j++] = integer;
                }
            }
            if (j >= k) {
                break;
            }
        }
        return retArr;
    }
}