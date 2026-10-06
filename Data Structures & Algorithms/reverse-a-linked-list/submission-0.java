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

class Solution {
    public ListNode reverseList(ListNode head) {

        // 0 -> 1 -> 2 -> 3
        
        // 3 -> 2 -> 1 -> 0

        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while(current != null && current.next != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        if(current != null){
            current.next = prev;
        }

        // System.out.println(current.val);/

        return current;
    }
}
