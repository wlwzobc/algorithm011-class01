class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if (countMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}