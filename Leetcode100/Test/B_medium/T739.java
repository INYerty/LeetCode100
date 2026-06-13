package Test.B_medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
/**
 * 739. 每日温度
 *
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温
 * 度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 提示：
 * * 1 <= temperatures.length <= 105
 * * 30 <= temperatures[i] <= 100
 *
 * 链接：https://leetcode.cn/problems/daily-temperatures/
 */

public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
     /*        int n = temperatures.length;
        int[] res =new int[n];
        for (int i = 0; i < n; i++) {
//            if (i == temperatures.length-1){
//                // 最后返回0;
//                st.clear();
//            }
            int cur = i+1;
            while(cur<n){
                if (temperatures[cur]>temperatures[i]){
                    res[i] = cur-i;
                }
                cur ++;
            }
        }
        return res;*/
        int n = temperatures.length;
        Deque<Integer> st = new LinkedList<>();
        int[] res = new int[n];
        st.push(0);// 栈放下标
        for (int i = 1; i < n; i++) {
            if (!st.isEmpty()&&temperatures[i]<=temperatures[st.peek()]){
                st.push(i);
            }else{
                // 找到了第一个比栈顶大的元素
                while(!st.isEmpty()&&temperatures[i]>temperatures[st.peek()]){
                    res[st.peek()] = i-st.peek();
                    st.pop();
                }
                st.push(i);
            }
        }
        return res;
    }
}