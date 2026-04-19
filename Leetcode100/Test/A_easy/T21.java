package Test.A_easy;

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
}
