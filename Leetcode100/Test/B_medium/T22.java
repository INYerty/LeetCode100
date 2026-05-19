package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

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
