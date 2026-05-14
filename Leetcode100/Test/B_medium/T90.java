package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrace(nums,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,int startIndex){
        result.add(new ArrayList<>(path));
        for(int i = startIndex;i<nums.length;i++){
            // 同层去重
            if(i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTrace(nums,i+1);
            path.removeLast();
        }
    }


}
