package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrace(nums,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] nums,int startIndex){
        if (path.size()>=2) result.add(new ArrayList<>(path));
        if (startIndex>nums.length) return;
        // 单层去重逻辑
        HashSet<Integer> used = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
//            if (startIndex<i && nums[i] == nums[i-1]) continue;
            // 单层去重逻辑path  相等于是set 进行自动的去重
            if (used.contains(nums[i])) continue;
            if (!path.isEmpty() && nums[i] < path.get(path.size()-1)) continue;

            used.add(nums[i]);
            path.add(nums[i]);
            backTrace(nums,i+1);
            path.removeLast();
        }
    }
}
