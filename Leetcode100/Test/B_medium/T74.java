package Test.B_medium;

import java.util.ArrayList;

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
