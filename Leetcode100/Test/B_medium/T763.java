package Test.B_medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 763. 划分字母区间
 *
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"
 * ] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 * 提示：
 * * 1 <= s.length <= 500
 * * s 仅由小写英文字母组成
 *
 * 链接：https://leetcode.cn/problems/partition-labels/
 */

public class T763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chararray = s.toCharArray();
        for(int i = 0;i<chararray.length;i++){
            map.put(chararray[i], i);
        }
        int[] index = new int[chararray.length];
        for(int i = 0; i< index.length; i++){
            index[i] = map.get(chararray[i]);
        }
        int site = index[0];
        List<Integer> list = new ArrayList<>();
        int start = 0;
        for(int i = start;i <= site;i++){
            if(index[i] > site){
                site = index[i];
            }
            if (i==site){
                list.add(site-start +1);
                if (site==index.length-1){
                    break;
                }
                start = i+1;
                site = index[i+1];
            }
        }
        return list;
    }
}