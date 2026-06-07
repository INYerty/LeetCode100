package Test.week.week505;

import java.util.ArrayList;
import java.util.List;

public class T2 {
    public List<String> generateValidStrings(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(n,k,0,0,new StringBuilder(),res);
        return res;
    }

    private void backtrack(int n, int k, int cost, int index, StringBuilder sb, List<String> res) {
        if(cost > k) return;
        if(index == n){
            //收集结果
            res.add(sb.toString());
            return;
        }

        sb.append('0');
        index++;
        backtrack(n,k,cost,index,sb,res);
        sb.deleteCharAt(sb.length()-1);

        if(!sb.isEmpty() && sb.charAt(sb.length()-1) == '1'){
            sb.append('1');
            index++;
            backtrack(n,k,cost+index,index,sb,res);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
    }

}
