package Solutions;


import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle141 {

    public static void main(String[] args) {
        System.out.println("Solution");
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> aknwoledged = new HashSet<>();


        while(head != null){
            if(aknwoledged.contains(head)){
                return true;
            }

            aknwoledged.add(head);

            head = head.next;
        }

        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        if(head == null || fastPointer.next == null){
            return false;
        }

        while(fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;


            if(slowPointer == fastPointer){
                return true;
            }
        }

        return false;
    }
}