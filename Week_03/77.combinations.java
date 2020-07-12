class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retList = new ArrayList<>();
        backtrack(1, n, k, new ArrayList(), retList);
        return retList;
    }

    private void backtrack(int current, int n, int k, List<Integer> list, List<List<Integer>> retList){
        if (list.size() == k) {
            retList.add(new ArrayList(list));
            return;
        }
        for (int i = current; i < n + 1; i++) {
            list.add(i);
            backtrack(i + 1, n, k, list, retList);
            list.remove(list.size() - 1);
        }
    }
}