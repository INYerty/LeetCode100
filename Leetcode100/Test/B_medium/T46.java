package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T46 {

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backTrace(nums,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,boolean[] used){
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                path.add(nums[i]);
                used[i] = true;
                backTrace(nums,used);
                used[i] = false;
                path.removeLast();
            }

        }
    }
}
