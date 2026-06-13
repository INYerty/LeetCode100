package Test.B_medium;

import java.util.Arrays;
import java.util.Stack;
/**
 * 150. 逆波兰表达式求值
 *
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 [https://baike.baidu.com/item/%E9%80%86%E6%
 * B3%A2%E5%85%B0%E5%BC%8F/128437] 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * * 两个整数之间的除法总是 向零截断 。
 * * 表达式中不含除零运算。
 * * 输入是一个根据逆波兰表示法表示的算术表达式。
 * * 答案及所有中间计算结果可以用 32 位 整数表示。
 * 提示：
 * * 1 <= tokens.length <= 104
 * * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 *
 * 链接：https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */

public class T150 {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack<>();
            for(String token : tokens){
                if(token.equals("+")){
                    if(st.size()>=2){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int sum = num1+num2;
                        st.push(sum);
                    }
                }
                else if(token.equals("-")){
                    if(st.size()>=2){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int sub = num2-num1;
                        st.push(sub);
                    }
                }
                else if(token.equals("*")){
                    if(st.size()>=2){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int mult = num1*num2;
                        st.push(mult);
                    }
                }
                else if(token.equals("/")){
                    if(st.size()>=2){
                        int num1 = st.pop();
                        int num2 = st.pop();
                        int div = num2/num1;
                        st.push(div);
                    }
                }else{
                    st.push(Integer.parseInt(token));
                }
            }
            return st.peek();
        }
}