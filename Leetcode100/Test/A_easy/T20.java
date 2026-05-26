package Test.A_easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

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
