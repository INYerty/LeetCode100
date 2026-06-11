package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;

public class T406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // 身高降序
            } else {
                return a[1] - b[1]; // k 值升序
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
