package Test.A_easy;

import Test.B_medium.T2;
/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 提示：
 * * 两个链表的节点数目范围是 [0, 50]
 * * -100 <= Node.val <= 100
 * * l1 和 l2 均按 非递减顺序 排列
 *
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists/
 */

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode left = new ListNode(0);
        ListNode cur = left;
        while(list1!=null&&list2!=null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;  //选中两个链表对应数字较小的一个,并且移动选中链表的指针。
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        //如果长度不一致，把长的直接接到后面就行了。
        cur.next = (list1!=null) ? list1 :list2;

        return left.next;
    }


    public static void main(String[] args) {
        T21 t21 = new T21();

        // 1. 构建第一个链表
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        // 2. 构建第二个链表
        ListNode l2 = new ListNode(1);

        ListNode result = t21.mergeTwoLists(l1, l2);

        // 4. 打印结果
        System.out.print("Result: ");
        printList(result);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
    }
}