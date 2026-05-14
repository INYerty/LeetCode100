package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates,target,0);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTrace(int[] candidates,int target,int startIndex){
        if (sum(path)>target) return;

        if (sum(path) == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            /*
              树层不重复，树枝可重复这就话很适合描述这题，
              那么树枝可重复这句话如果在题目给出"一个元素不能使用两次"的时候就不适用了
             */
            if (i>startIndex && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            backTrace(candidates,target,i+1);
            path.removeLast();
        }
    }

    public int sum(List<Integer> path){
        int sum = 0;
        for(int i:path){
            sum+=i;
        }
        return sum;
    }
}
