package Test.B_medium;

import java.util.HashSet;

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
