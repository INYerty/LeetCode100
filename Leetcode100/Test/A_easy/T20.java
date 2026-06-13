package Test.A_easy;

import java.util.HashMap;
import java.util.Stack;
/**
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 * 提示：
 * * 1 <= s.length <= 104
 * * s 仅由括号 '()[]{}' 组成
 *
 * 链接：https://leetcode.cn/problems/valid-parentheses/
 */

public class T20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        char[] charArray = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (st.isEmpty())
                    return false;
                Character peek = st.peek();
                if (map.get(peek) == c) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}