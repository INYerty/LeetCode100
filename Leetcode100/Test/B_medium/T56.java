package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;

public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 当前区间
        int start = intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> newIntervals = new ArrayList<>();



        for (int i = 1; i < intervals.length; i++) {
            // 整行交换
//            if (intervals[i][0] > intervals[i+1][0]) {
//                int[] temp = intervals[i];
//                intervals[i] = intervals[i+1];
//                intervals[i+1] = temp;
//            }
            // 判断是否重叠
            if (intervals[i][0] <= end) {
                // 左区间右边界越界
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            } else { // 不重叠
                newIntervals.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        newIntervals.add(new int[]{start, end});

        System.out.println(newIntervals);
        return newIntervals.toArray(new int[newIntervals.size()][2]);
    }




    public static void main(String[] args) {
        T56 t = new T56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        t.merge(intervals);
    }
}
