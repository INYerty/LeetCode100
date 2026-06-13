package Test.B_medium;

import java.util.HashSet;
/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * 提示：
 * * 0 <= s.length <= 5 * 104
 * * s 由英文字母、数字、符号和空格组成
 *
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */

public class T3 {
    public static void main(String[] args) {
        T3 t = new T3();
        String s = "abcabcbb";
        System.out.println(t.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
//        String[] str = s.split("");
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}