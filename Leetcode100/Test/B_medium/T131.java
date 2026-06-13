package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * 131. 分割回文串
 *
 * 给你一个字符串 s，请你将 s 分割成一些 子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 提示：
 * * 1 <= s.length <= 16
 * * s 仅由小写英文字母组成
 *
 * 链接：https://leetcode.cn/problems/palindrome-partitioning/
 */

public class T131 {
    public List<List<String>> partition(String s) {
        backTracing(s,0);
        return result;
    }

    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public void backTracing(String s,int startIndex){
        if (startIndex == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String son = s.substring(startIndex, i+1);
            if (isPalindrome(son)){
                path.add(son);
            }else {
                continue;
            }
            backTracing(s,i+1);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String son){
        String reverse = new StringBuilder(son).reverse().toString();
        return son.compareTo(reverse) == 0;
    }
}