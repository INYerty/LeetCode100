package Test.B_medium;

import java.util.ArrayList;
/**
 * 74. 搜索二维矩阵
 *
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * * 每行中的整数从左到右按非严格递增顺序排列。
 * * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 * 提示：
 * * m == matrix.length
 * * n == matrix[i].length
 * * 1 <= m, n <= 100
 * * -104 <= matrix[i][j], target <= 104
 *
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix/
 */

public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                integers.add(matrix[i][j]);
            }
        }
        int left = 0;
        int right = integers.size();
        if (target<integers.getFirst()||target>integers.getLast()) return false;
        while(left<=right){
            int mid = (left+right)/2;
            if (target>integers.get(mid)){
                left = mid+1;
            }else if (target<integers.get(mid)){
                right = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
    /*
    // 方法二
        public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                list.add(matrix[i][j]);
            }
        }
        int right = list.size()-1;
        int result = 0;
        while(left<right){
            int mid = (left+right)/2;
            if (target<list.get(mid)){
                right = mid-1;
            } else if (target>list.get(mid)) {
                left = mid+1;
            }else {
                return true;
            }
        }
        return false;
    }
    */
}