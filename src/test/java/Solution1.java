public class Solution1 implements Solution {
    @Override
    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        int[][] mat = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            mat[i][0] = 0;
        }
        for (int j = 0; j < n+1; j++) {
            mat[0][j] = 0;
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (i == 1) {
                    mat[i][j] = mat[i][j-1]+grid[i-1][j-1];
                } else if (j == 1) {
                    mat[i][j] = mat[i-1][j]+grid[i-1][j-1];
                } else {
                    mat[i][j] = Math.min(mat[i - 1][j], mat[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }

//        for (int i = 0; i < m+1; i++) {
//            for (int j = 0; j < n+1; j++) {
//                System.out.print(mat[i][j]+" ");
//            }
//            System.out.println();
//        }

        return mat[m][n];
    }
}
