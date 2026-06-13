package Test.B_medium;

import java.util.Arrays;
import java.util.Stack;

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
