package Solutions;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class ReverseLinkedList206 {

    public static void main(String[] args) {
        // We have 3 options:
        // Recurrency
        // Stack
        // Iterative method

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        printList(head);
        System.out.println("");
        head = reverseListWithStack(head);
        printList(head);
    }

    public static ListNode reverseListByIterativeMethod(ListNode head) {
        ListNode curr = head, prev = null, next;

        while(curr != null){
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static ListNode reverseListByRecursion(ListNode head) {


        if(head == null || head.next == null){
            return head;
        }

        ListNode reversedHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }

    public static ListNode reverseListWithStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null){
            stack.add(temp);
            temp = temp.next;
        }

        if(!stack.isEmpty()){
            head = stack.pop();
            temp = head;

            while (!stack.isEmpty()){

                temp.next = stack.pop();

                temp = temp.next;
            }
            temp.next = null;
        }


        return head;

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


