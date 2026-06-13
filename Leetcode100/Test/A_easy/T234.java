package Test.A_easy;
/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 提示：
 * * 链表中节点数目在范围[1, 105] 内
 * * 0 <= Node.val <= 9
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode.cn/problems/palindrome-linked-list/
 */

public class T234 {

    public ListNode reverse(ListNode cur, ListNode pre){
        if(cur==null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp,cur);
    }

    public boolean isPalindrome(ListNode head) {
        //找中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        //反转链表
        ListNode reverse = reverse(mid, null);
        while(reverse!=null){
            if(reverse.val!=head.val) return false;
            reverse = reverse.next;
            head = head.next;
        }
        return true;

    }


}