package Test.week.week505;

import java.util.ArrayList;
import java.util.List;
/**
 * 2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 提示：
 * * 每个链表中的节点数在范围 [1, 100] 内
 * * 0 <= Node.val <= 9
 * * 题目数据保证列表表示的数字不含前导零
 *
 * 链接：https://leetcode.cn/problems/add-two-numbers/
 */

public class T2 {
    public List<String> generateValidStrings(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(n,k,0,0,new StringBuilder(),res);
        return res;
    }

    private void backtrack(int n, int k, int cost, int index, StringBuilder sb, List<String> res) {
        if(cost > k) return;
        if(index == n){
            //收集结果
            res.add(sb.toString());
            return;
        }

        sb.append('0');
        index++;
        backtrack(n,k,cost,index,sb,res);
        sb.deleteCharAt(sb.length()-1);

        if(!sb.isEmpty() && sb.charAt(sb.length()-1) == '1'){
            sb.append('1');
            index++;
            backtrack(n,k,cost+index,index,sb,res);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
    }

}