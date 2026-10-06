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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);

        ListNode end = dummy;
        ListNode front;

        while (end != null) {
            front = end;

            int i = 0;
            while (i < k && end.next != null) {
                end = end.next;
                i++;
            }

            System.out.println(i);

            if (i != k) {
                break;
            }

            ListNode next = end.next;
            ListNode start = front.next;

            end.next = null;

            reverseList(start);

            front.next = end;
            start.next = next;
            end = start;
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;

        ListNode curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
