package Test.B_medium;
/**
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * * 每行的元素从左到右升序排列。
 * * 每列的元素从上到下升序排列。
 * 提示：
 * * m == matrix.length
 * * n == matrix[i].length
 * * 1 <= n, m <= 300
 * * -109 <= matrix[i][j] <= 109
 * * 每行的所有元素从左到右升序排列
 * * 每列的所有元素从上到下升序排列
 * * -109 <= target <= 109
 *
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */

public class T240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;//左右长度
        int n = matrix.length;//上下长度
        for (int i = 0; i < n; i++) {
            int lenMax = matrix[i][m-1];
            if(target>lenMax){
                continue;
            }else{
                for(int j = 0 ; j<= m-1;j++){
                    if (target == matrix[i][j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        T240 t = new T240();
        boolean b = t.searchMatrix(new int[][]{{-5}}, -5);
        System.out.println(b);
    }
}