package Test.A_easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/**
 *136. 只出现一次的数字
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * https://leetcode.cn/problems/single-number/description/
 */
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
