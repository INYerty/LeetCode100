package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

public class T216 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> situation = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(n,k,1,0);
        return result;
    }
    public void backTracing(int n,int k,int startIndex,int sum){
        // 确定输出  终止条件
        if (situation.size()==k){
            if(sum == n){
                result.add(new ArrayList<>(situation));
            }
            return;
        }
        // 每层遍历逻辑
        for(int i = startIndex;i<=9-(k-situation.size())+1;i++){
            situation.add(i);
            backTracing(n,k,i+1,sum(situation));
            situation.removeLast();
        }
    }
    public int sum(List<Integer> situation){
        int sum = 0;
        for(int i:situation){
            sum+=i;
        }
        return sum;
    }
}
