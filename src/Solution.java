class LinkedList {
    static ListNode head1, head2;
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode prev = null;
        ListNode temp = null;
        int excess = 0, sum;

        while (l1!= null || l2!= null) {
            sum = excess + (l1!= null ? l1.val : 0) + (l2!= null ? l2.val : 0);
            excess = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new ListNode(sum);
            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }
            prev = temp;
            if (l1!= null) {
                l1 = l1.next;
            }
            if (l2!= null) {
                l2 = l2.next;
            }
        }
        if (excess > 0) {
            temp.next = new ListNode(excess);
        }
        return res;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head1 = new ListNode(7);
        list.head1.next = new ListNode(5);
        list.head1.next.next = new ListNode(9);
        list.printList(head1);

        list.head2 = new ListNode(8);
        list.head2.next = new ListNode(4);
        list.head2.next = new ListNode(9);
        list.printList(head2);

        ListNode resultedList = list.addTwoNumbers(head1, head2);
        list.printList(resultedList);
    }
}