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
    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null){
            return ;
        }

        Stack<ListNode> st = new Stack<>();
        ListNode temp = head.next;

        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }


        temp = head;

        while(st.peek() != temp && st.peek() != temp.next){
            ListNode current = st.pop();
            current.next = temp.next;
            temp.next = current;
            temp = temp.next.next;
            st.peek().next = null;
        }

        // return head;/
        
    }
}
