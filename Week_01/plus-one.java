class Solution {
    public int[] plusOne(int[] digits) {
        int d = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + d;
            d = temp / 10;
            temp %= 10;
            digits[i] = temp;
            if (d < 1) {
                return digits;
            }
        }
        if (d != 0) {
            int[] retArr = new int[digits.length + 1];
            retArr[0] = d;
            return retArr;
        }
        return digits;
    }
}