package Test.B_medium;
/**
 * 73. 矩阵置零
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 [http://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95] 算
 * 法。
 * 提示：
 * * m == matrix.length
 * * n == matrix[0].length
 * * 1 <= m, n <= 200
 * * -231 <= matrix[i][j] <= 231 - 1
 * 进阶：
 * * 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。
 * * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * * 你能想出一个仅使用常量空间的解决方案吗？
 *
 * 链接：https://leetcode.cn/problems/set-matrix-zeroes/
 */

public class T73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] zeroRow = new boolean[row];
        boolean[] zeroColumn = new boolean[column];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroColumn[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++) {
                if(zeroRow[i] || zeroColumn[j]){
                    matrix[i][j] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        T73 t = new T73();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        t.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}