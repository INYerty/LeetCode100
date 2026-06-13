package Test.B_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 提示:
 * * 1 <= s.length, p.length <= 3 * 104
 * * s 和 p 仅包含小写字母
 *
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */

public class T438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] wCount = new int[26];

        // 先统计 p 的频率，以及第一个窗口
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            wCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, wCount)) res.add(0);

        // 滑动窗口：窗口大小固定为 p.length()
        for (int i = p.length(); i < s.length(); i++) {
            wCount[s.charAt(i) - 'a']++;               // 新字符进来
            wCount[s.charAt(i - p.length()) - 'a']--;  // 旧字符出去
            if (Arrays.equals(pCount, wCount)) res.add(i - p.length() + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        T438 t = new T438();
        String s = "baa";
        String p = "aa";
        t.findAnagrams(s, p);

    }
}