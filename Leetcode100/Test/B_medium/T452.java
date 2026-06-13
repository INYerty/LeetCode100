package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
