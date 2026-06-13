package Test.B_medium;
/**
 * 48. 旋转图像
 *
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 [https://baike.baidu.com/item/%E5%8E%9F%E5%9C%B0%E7%AE%97%E6%B3%95]
 *  旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 提示：
 * * n == matrix.length == matrix[i].length
 * * 1 <= n <= 20
 * * -1000 <= matrix[i][j] <= 1000
 *
 * 链接：https://leetcode.cn/problems/rotate-image/
 */

public class T48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        // 上下翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }

        }

    }


    public static void main(String[] args) {
        T48 t = new T48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        t.rotate(matrix);


    }
}