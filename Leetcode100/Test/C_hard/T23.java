package Test.C_hard;

import java.util.ArrayList;
import java.util.Collections;
/**
 * 23. 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 提示：
 * * k == lists.length
 * * 0 <= k <= 10^4
 * * 0 <= lists[i].length <= 500
 * * -10^4 <= lists[i][j] <= 10^4
 * * lists[i] 按 升序 排列
 * * lists[i].length 的总和不超过 10^4
 *
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists/
 */

public class T23 {
    //🐍他妈转数组排序  秒了!
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> array = new ArrayList<>();
        int num = lists.length;
        for (int i = 0 ;i<num;i++){
            while (lists[i]!=null){
                array.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        Collections.sort(array);
        ListNode dummy = new ListNode(0);
        ListNode listNode = dummy;
        for (int i = 0; i < array.size(); i++){
            listNode.next = new ListNode(array.get(i));
            listNode = listNode.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        T23 t23 = new T23();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;


        ListNode res = t23.mergeKLists(listNodes);

        printList(res);
    }


    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }

}