package Test.A_easy;

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                result.next = list1;
            }
            else if(list1.val>list2.val) {
                result.next = list2;
            }else{
                result.next = list1;
                result.next.next = list2;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return result;
    }
}
