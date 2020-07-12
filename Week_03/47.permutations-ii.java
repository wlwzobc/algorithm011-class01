class Solution {

    List<List<Integer>> retList = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>(nums.length);
        boolean[] used = new boolean[nums.length];
        recursion(nums.length, 0, numList, used, nums);
        return retList;
    }

    private void recursion(int size, int deep, List<Integer> numList, boolean[] used, int[] nums){
        if (deep == size) {
            retList.add(new ArrayList(numList));
            return;
        }
        for (int i = 0; i < size; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                break;
            }
            numList.add(nums[i]);
            used[i] = true;
            recursion(size, deep +1,  numList, used, nums);
            used[i] = false;
            numList.remove(numList.size() - 1);
        }
    }

}