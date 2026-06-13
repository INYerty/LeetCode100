package Test.B_medium;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
/**
 * 39. 组合总和
 *
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 targe
 * t 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 提示：
 * * 1 <= candidates.length <= 30
 * * 2 <= candidates[i] <= 40
 * * candidates 的所有元素 互不相同
 * * 1 <= target <= 40
 *
 * 链接：https://leetcode.cn/problems/combination-sum/
 */

public class T39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracing(candidates,target,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void backTracing(int[] candidates, int target , int startIndex){
        if (sum(path)>target) return;
        if (sum(path) == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(i);
            backTracing(candidates,target,i+1);
            path.removeLast();
        }
    }

    public int sum(List<Integer> path){
        int sum = 0;
        for (int i : path)
            sum+=i;
        return sum;
    }
}