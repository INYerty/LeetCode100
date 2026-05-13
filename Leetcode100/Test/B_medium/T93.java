package Test.B_medium;

import java.util.ArrayList;
import java.util.List;

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
