class Solution {
    List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int num : nums) {
            numList.add(num);
        }
        recursion(numList.size(), 0, numList);
        return retList;
    }

    private void recursion(int size, int deep, List<Integer> numList){
        if (deep == size - 1) {
            retList.add(new ArrayList(numList));
            return;
        }
        for (int i = deep; i < size; i++) {
            if (i != deep) {
                Collections.swap(numList, deep, i);
            }
            recursion(size, deep + 1, numList);
            if (i != deep) {
                Collections.swap(numList, deep, i);
            }
        }
    }
     
}