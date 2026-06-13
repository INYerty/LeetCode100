package Test.B_medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * [https://pic.leetcode.cn/1752723054-mfIHZs-image.png]
 * 提示：
 * * 1 <= digits.length <= 4
 * * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */

public class T17 {
    HashMap<String, List<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    /*public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return result;

        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));

        backTrace(0, digits);
        return result;
    }*/
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return result;
        map.put("2", List.of("a", "b", "c"));
        map.put("3", List.of("d", "e", "f"));
        map.put("4", List.of("g", "h", "i"));
        map.put("5", List.of("j", "k", "l"));
        map.put("6", List.of("m", "n", "o"));
        map.put("7", List.of("p", "q", "r", "s"));
        map.put("8", List.of("t", "u", "v"));
        map.put("9", List.of("w", "x", "y", "z"));
        backTrace(0,digits);
        return result;
    }


    public void backTrace(int startIndex, String digits) {
        /*if (startIndex == digits.length()) {
            result.add(path.toString());
            return;
        }
        String digitStr = String.valueOf(digits.charAt(startIndex));
        List<String> alphabets = map.get(digitStr);
        for (int i = 0; i < alphabets.size(); i++) {
            path.append(alphabets.get(i));
            backTrace(startIndex + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }*/
        if (startIndex == digits.length()){
            result.add(path.toString());
            return;
        }
        String digitStr = String.valueOf(digits.charAt(startIndex));
        List<String> alphabets = map.get(digitStr);

        for (int i = 0; i < alphabets.size(); i++) {
            path.append(alphabets.get(i));
            backTrace(startIndex+1,digits);
            path.deleteCharAt(path.length()-1);
        }
    }
}
