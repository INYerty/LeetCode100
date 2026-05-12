package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
