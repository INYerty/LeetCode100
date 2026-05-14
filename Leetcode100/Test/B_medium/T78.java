package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums,0);
        return result;
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTrace(nums,i+1);
            path.removeLast();
        }

    }

}
