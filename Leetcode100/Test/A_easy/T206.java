package Test.A_easy;
/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 提示：
 * * 链表中节点的数目范围是 [0, 5000]
 * * -5000 <= Node.val <= 5000
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 *
 * 链接：https://leetcode.cn/problems/reverse-linked-list/
 */

public class T206 {

    /*此解法是递归思路，将循环拆成了递归调用。

 代码随想录
 https://www.bilibili.com/video/BV1nB4y1i7eL/?spm_id_from=333.337.search-card.all.click&vd_source=2f45539d411bad86b3920563c6a0cd76
    NB*/

    public ListNode reverse(ListNode cur, ListNode pre) {
        if (cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        reverse(temp, cur);
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}

/* 双指针法
* 该方法是双指针法。

利用cur以及pre指针，外加一个temp指针存cur所移动的下一个位置，
* 即ListNode temp = cur.next;
* cur.next = pre;  (用来反转方向)
*  cur = temp;  (用来向后移动)
*
*
* public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
}
* */

