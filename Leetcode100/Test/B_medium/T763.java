package Test.B_medium;

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

// TODO
public class T763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, i}); // 初次出现，左右边界都设为 i
            } else {
                map.get(c)[1] = i;
            }
        }

        /*ArrayList<Integer> integers = new ArrayList<>();

        Collection<int[]> values = map.values();
        List<int[]> list = values.stream().toList();
        for(int i = 0;i<list.size();i++){
            for (int j = 0; j < list.size(); j++) {
                if(list.get(i)[1]+1 == list.get(j)[0]){
                    integers.add(j);
                }
            }
        }
        //  计算差值*/
        return List.of();
    }
}