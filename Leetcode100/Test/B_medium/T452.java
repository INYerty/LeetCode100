package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 452. 用最少数量的箭引爆气球
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。
 * 墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的
 * 气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。
 * 在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart ≤ x ≤ xend，则该气球会被 引
 * 爆 。可以射出的弓箭的数量 没有限制 。弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * 提示:
 * * 1 <= points.length <= 105
 * * points[i].length == 2
 * * -231 <= xstart < xend <= 231 - 1
 *
 * 链接：https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 */

public class T452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        int left = points[0][0],right = points[0][1];
        List<int[]> list = new ArrayList<>();
        for(int[] point : points){
            if (point[0] <= right) {
                left = Math.max(left, point[0]);
                right = Math.min(right, point[1]);
            } else {
                list.add(new int[]{left, right});
                left = point[0];
                right = point[1];
            }
        }
        return list.size()+1;
    }

    // 方法二：————————————————————————————————————————————————————————————————————————
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (p1,p2)->{
            return Integer.compare(p1[0],p2[0]);
        });
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        List<int[]> list = new ArrayList<>();
        for(int[] point : points){
            if(point[0] <= right){
                if(point[1] <= right){
                    right = point[1];
                }
            }else{
                list.add(new int[]{left,right});
                left = point[0];
                right = point[1];
            }
        }
        return list.size() + 1;
    }
}