package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * * 只使用数字1到9
 * * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * 提示:
 * * 2 <= k <= 9
 * * 1 <= n <= 60
 *
 * 链接：https://leetcode.cn/problems/combination-sum-iii/
 */

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

    public static void main(String[] args) {
        T216 t216 = new T216();
        System.out.println(t216.combinationSum3(3,7));
        System.out.println(t216.combinationSum3(3,9));
        System.out.println(t216.combinationSum3(4,1));

    }
}