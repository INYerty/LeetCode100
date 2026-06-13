package Test.B_medium;

import java.util.ArrayList;
import java.util.List;
/**
 * 93. 复原 IP 地址
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.3
 * 12" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 提示：
 * * 1 <= s.length <= 20
 * * s 仅由数字组成
 *
 * 链接：https://leetcode.cn/problems/restore-ip-addresses/
 */

public class T93 {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12) return result;
        backTrack(s,0,0);
        return result;
    }

    // startIndex: 搜索的起始位置， pointNum:添加逗点的数量
    private void backTrack(String s, int startIndex, int pointNum) {
       // 确定程序的出口
        if (pointNum == 3){ //有三个点分割时，正好将IP地址切分成四段，那么这时候结束分割
            // 收集、处理结果
            //  处理第四段IP段
            if (isValid(s,startIndex,s.length()-1)){
                result.add(s);
            }

            return;
        }

        // 单层循环的逻辑
        for (int i = startIndex ; i<s.length()-1 ; i++){
            // 开始切割字符串
            if (isValid(s,startIndex,i)){
                s = s.substring(0,i+1) + "." + s.substring(i+1);
                pointNum++;
                backTrack(s,i+2,pointNum);
                pointNum--;
                s = s.substring(0,i+1)+s.substring(i+2);
            }else{
                break;
            }

        }
    }

    private boolean isValid(String s,int start,int end) {
        if (start>end) return false;
        if (s.charAt(start) == '0'&&end!=start) return false;

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) >'9'||s.charAt(i)<'0'){
                return false;
            }
        }
        if (Integer.parseInt(s.substring(start,end+1))>255){
            return false;
        }

        return true;
    }
}