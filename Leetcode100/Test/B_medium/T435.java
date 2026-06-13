package Test.B_medium;

import java.util.Arrays;
/**
 * 435. 无重叠区间
 *
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
 * 提示:
 * * 1 <= intervals.length <= 105
 * * intervals[i].length == 2
 * * -5 * 104 <= starti < endi <= 5 * 104
 *
 * 链接：https://leetcode.cn/problems/non-overlapping-intervals/
 */

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