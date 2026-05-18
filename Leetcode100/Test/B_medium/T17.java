package Test.B_medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class T17 {
    HashMap<String, List<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();

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

        backTrace(0, digits);
        return result;
    }

    public void backTrace(int startIndex, String digits) {
        if (startIndex == digits.length()) {
            result.add(path.toString());
            return;
        }
        String digitStr = String.valueOf(digits.charAt(startIndex));
        List<String> alphabets = map.get(digitStr);
        for (int i = 0; i < alphabets.size(); i++) {
            path.append(alphabets.get(i));
            backTrace(startIndex + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

