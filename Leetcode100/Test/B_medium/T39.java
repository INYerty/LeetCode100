package Test.B_medium;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

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
