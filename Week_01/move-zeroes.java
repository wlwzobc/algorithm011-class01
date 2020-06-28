class Solution {
    public void moveZeroes(int[] nums) {
        int firstZeroNumIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if (i != firstZeroNumIndex) {
                    int temp = nums[firstZeroNumIndex];
                    nums[firstZeroNumIndex] = nums[i];
                    nums[i] = temp;
                }
                firstZeroNumIndex++;
            }
        }
    }
}