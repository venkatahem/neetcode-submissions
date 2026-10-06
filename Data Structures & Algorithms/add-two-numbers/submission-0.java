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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 321
        // 654
        // 975

        // 123
        // 456
        // 579

        // correct
        // 327
        // 694
        // 1021
        // reverse
        // 723
        // 496
        // 1201

        // int current = 0;
        int carry = 0;

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (temp1 != null && temp2 != null) {
            int a = temp1.val;
            int b = temp2.val;

            int sum = a + b + carry;

            int current = sum % 10;

            carry = sum / 10;

            ListNode curr = new ListNode(current);

            temp.next = curr;
            temp = temp.next;

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while (temp1 != null) {
            int a = temp1.val;

            int sum = a + carry;

            int current = sum % 10;

            carry = sum / 10;

            ListNode curr = new ListNode(current);

            temp.next = curr;
            temp = temp.next;

            temp1 = temp1.next;
        }

        while (temp2 != null) {
            int a = temp2.val;

            int sum = a + carry;

            int current = sum % 10;

            carry = sum / 10;

            ListNode curr = new ListNode(current);

            temp.next = curr;
            temp = temp.next;

            temp2 = temp2.next;
        }

        if(carry != 0){
            ListNode curr = new ListNode(carry);

            temp.next = curr;
            temp = temp.next;
        }

        return dummy.next;
    }
}
