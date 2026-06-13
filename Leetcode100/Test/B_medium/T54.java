package Test.B_medium;


import java.util.ArrayList;
import java.util.List;
/**
 * 54. 螺旋矩阵
 *
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 提示：
 * * m == matrix.length
 * * n == matrix[i].length
 * * 1 <= m, n <= 10
 * * -100 <= matrix[i][j] <= 100
 *
 * 链接：https://leetcode.cn/problems/spiral-matrix/
 */

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return res;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            // 左 -> 右
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // 上 -> 下
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 右 -> 左
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 下 -> 上
            if(left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        T54 t = new T54();
        int[][] matrix = {{1, 2}};
        List<Integer> integers = t.spiralOrder(matrix);
        System.out.println( integers);
    }
}

