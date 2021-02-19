package arithmetic.recursion;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        ListNode node06 = new ListNode(6);
        ListNode node07 = new ListNode(7);
        node01.next = node02;node02.next = node03;node03.next=node04;node04.next=node05;node05.next=node06;node06.next = node07;
        System.out.println(node01);
        ReverseKGroup reverseKGroup = new ReverseKGroup();
//        ListNode reverse = reverseKGroup.reverse(node01);
        ListNode res = reverseKGroup.reverseKGroup(node01, 3);
        System.out.println(res);
    }
    ListNode reverse(ListNode head){
        ListNode pre,cur,next;

        pre = null;cur = head;next = head;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre= cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseKGroup(ListNode head,int k){
        if (head == null) return null;

        //要反转的区间 [head,tail) 包含 K 个待反转元素
        ListNode pre,tail;
        pre = tail = head;
        for (int i = 0; i < k; i++) {
            //不足 K 个，不需要反转
            if (tail == null) return head;
            tail = tail.next;
        }
        //反转前 K 个元素
        ListNode newNode = reverse(pre,tail);
        pre.next = reverseKGroup(tail, k);

        return newNode;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre,cur,next;

        pre = null;cur = head;next = head;
        while (cur != tail){
         next = cur.next;
         cur.next = pre;
         pre = cur;
         cur = next;

        }
        return pre;
    }
}
