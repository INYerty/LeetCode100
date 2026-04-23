package Test.A_easy;

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


