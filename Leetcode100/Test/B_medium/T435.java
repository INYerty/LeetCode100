package Test.B_medium;

import java.util.Arrays;

public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1,i2)->{
            return i1[0] - i2[0];
        });
        int count = 0;
        for (int i = 0; i < intervals.length-1; i++) {
            if(intervals[i][1] > intervals[i+1][0]){
                count++;
                intervals[i+1][1] = Math.min(intervals[i][1],intervals[i+1][1]);
            }
        }
        return count;
    }
}
