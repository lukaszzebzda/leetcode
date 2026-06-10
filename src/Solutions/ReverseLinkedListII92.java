package Solutions;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        printList(head);
        System.out.println("");
        head = reverseBetween(head, 2,5);
        printList(head);
    }

    // Learned about this solution here: https://medium.com/@aniket.gaikwad.tech/reverse-linked-list-ii-34ac292fba40
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        //If we start reversing at 1 we left the dummy space to park with our pointers
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //prev will be a one node before nodes that needs reversing
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        for (int i = 0; i < right - left; ++i) {
            ListNode nextNode = current.next;

            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;

            System.out.println("Iteracja: " + i);
            printList(head);
            System.out.println("");
            System.out.println("Koniec iteracji: " + i);
        }


        return dummy.next;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null)
                System.out.print(" -> ");
            node = node.next;
        }
    }
}
