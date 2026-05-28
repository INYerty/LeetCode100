package Test.B_medium;

import java.util.Deque;
import java.util.LinkedList;


public class T394 {
    public String decodeString(String s) {
        /*Deque<Integer> kStack = new LinkedList<>();
        Deque<String> resStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        int nums = 0;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                nums = nums * 10 + (c - '0');
            } else if (c == '[') {
                // 将左括号前的数字压入栈；
                kStack.push(nums);
                resStack.push(res.toString());
                // 归零与重置
                nums = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                int dupNum = kStack.pop();
                String lastRes = resStack.pop();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < dupNum; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(lastRes + tmp);
            } else {
                res.append(c);
            }
        }

        return res.toString();*/

        // 单栈写法
        Deque<Object> stack = new LinkedList<>();
        int num = 0;
        StringBuilder cur = new StringBuilder();

        for(char c:s.toCharArray()){
            if (Character.isDigit(c)){
                num = num*10 + (c-'0');
            }else if (c == '['){
                // 将左括号之前的数字 和 字母入栈
                stack.push(num);
                stack.push(cur.toString());
                // 入栈后 清空原有值 用于记录下一个左括号之前的数字或字母
                num = 0;
                cur = new StringBuilder();
            } else if (c == ']') {
                // 开始拼接右括号之前的字母
                // 首先取出字母，因为我们当时后放的字母
                String prefix = (String) stack.pop();
                int repeatNum = (int) stack.pop();

                StringBuilder tmp = new StringBuilder();
                for(int i = 0; i<repeatNum;i++){
                    tmp.append(cur);
                }
                cur = new StringBuilder(prefix).append(tmp);
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
