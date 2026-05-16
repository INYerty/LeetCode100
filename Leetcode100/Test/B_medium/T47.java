package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrace(nums,used);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums, boolean[] used){
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i] == nums[i-1] && used[i-1]) continue;
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
