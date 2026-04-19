package Test.B_medium;

import java.util.*;

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

