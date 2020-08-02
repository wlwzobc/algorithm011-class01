class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[] mark = new int[column];
        mark[0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j > 0) {
                    mark[j] = grid[i][j] + mark[j - 1];
                } else if (i > 0 && j == 0) {
                    mark[j] += grid[i][j];
                } else if (i > 0 && j > 0) {
                    mark[j] = grid[i][j] + Math.min(mark[j - 1], mark[j]);
                }
            }
        }
        return mark[column - 1];
    }
    
}