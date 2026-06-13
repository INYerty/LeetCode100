package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 提示：
 * * 1 <= n <= 8
 *
 * 链接：https://leetcode.cn/problems/generate-parentheses/
 */

public class T22 {
    public List<String> generateParenthesis(int n) {
        backTrace(n,0,0);
        return result;
    }

    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public void backTrace(int n,int left,int right){
        if (path.length() == 2*n) {
            result.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            backTrace(n,left+1,right);
            path.deleteCharAt(path.length()-1);
        }
        if (right<left){
            path.append(")");
            backTrace(n,left,right+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}