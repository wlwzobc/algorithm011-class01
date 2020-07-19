class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (nums[i] + i >= lastIndex) {
                lastIndex = i;
            }
        }
        return lastIndex == 0;
    }
}