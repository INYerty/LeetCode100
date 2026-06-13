package Test.B_medium;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 测试用例保证输出的长度不会超过 105。
 * 提示：
 * * 1 <= s.length <= 30
 * * s 由小写英文字母、数字和方括号 '[]' 组成
 * * s 保证是一个 有效 的输入。
 * * s 中所有整数的取值范围为 [1, 300]
 *
 * 链接：https://leetcode.cn/problems/decode-string/
 */

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