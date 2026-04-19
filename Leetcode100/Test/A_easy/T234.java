package Test.A_easy;



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
