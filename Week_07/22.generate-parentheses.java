class Solution {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return Collections.emptyList();
        }
        List<String> retList = new ArrayList<>();
        recursion(retList, "", n, n);
        return retList;
    }

    private void recursion(List<String> list, String str, int left, int right){
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            recursion(list, str + "(", left - 1, right);
        }
        if (right > 0) {
            recursion(list, str + ")", left, right - 1);
        }
    }
}