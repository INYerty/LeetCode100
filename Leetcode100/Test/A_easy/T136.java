package Test.A_easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class T136 {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.remove(i);
            }
        }
        Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
        for(Map.Entry entry: entries){
            return Integer.parseInt(entry.getKey().toString());
        }
        return 0;
    }
}
