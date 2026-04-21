package Test.B_medium;

import java.util.Queue;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;
        ListNode pre = new ListNode(0);
        pre.next = cur;
        int length = 1;
        while(cur.next!=null){
            length++;
            cur = cur.next;
        }

        int index = length-n+1;
        return del(head,n,index);
    }

    public ListNode del(ListNode head,int n,int index){
        int start = 0;
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        ListNode run = pre;
        run.next = cur;
        while(cur!=null){
            start++;
            if(start != index){
                cur = cur.next;
                run = run.next;
            }else{
                //当前的cur就是需要移除的元素
                if(cur.next == null){//cur是最后一个元素,移除的是cur
                    run.next = null;
                    break;
                }else{
                    //不是最后一个
                    ListNode temp = cur.next;
                    run.next = temp;
                    break;
                }
            }
        }
        // 指针指到最前面
        return pre.next;
    }

    public static void main(String[] args) {
        T19 t19 = new T19();

        // 1. 构建第一个链表：9 -> 9 -> 9 (表示数字 999)
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode result = t19.removeNthFromEnd(l1,2);
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
