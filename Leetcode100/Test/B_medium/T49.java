package Test.B_medium;

import java.util.*;
/**
 * 49. 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 提示：
 * * 1 <= strs.length <= 104
 * * 0 <= strs[i].length <= 100
 * * strs[i] 仅包含小写字母
 *
 * 链接：https://leetcode.cn/problems/group-anagrams/
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String word: strs) {
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String key = new String(wordArray);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
                map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }

}

public class T49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution s = new Solution();
        s.groupAnagrams(strs);
    }
}
