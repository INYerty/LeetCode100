package Test.B_medium;

import java.util.HashMap;
import java.util.List;

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
