package arithmetic.recursion;


public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        ListNode node06 = new ListNode(6);
        node01.next = node02;node02.next = node03;node03.next=node04;node04.next=node05;node05.next=node06;
        System.out.println(node01);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
//        ListNode reverse = reverseLinkedList.reverse(node01);
//        System.out.println(reverse);
//        ListNode reverse1 = reverseLinkedList.reverse(reverse, 3);
//        System.out.println(reverse1);
        ListNode reverse2 = reverseLinkedList.reverse(node01, 3, 4);
        System.out.println(reverse2);
    }
    //反转链表
    ListNode  reverse(ListNode head){
        if (head.next == null ){return head;}
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
    ListNode successor = null;
    //反转链表的前 N 项
    ListNode  reverse(ListNode head,int n){
        if (head.next == null || n == 1){
            successor = head.next;
            return head;
        }
        ListNode node = reverse(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return node;
    }

    //反转一部分链表
    ListNode  reverse(ListNode head,int m,int n){
        if (head.next == null || m == 1){
                return reverse(head, n);
        }
        head.next = reverse(head.next, m-1, n-1);
        return head;
    }


}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}
