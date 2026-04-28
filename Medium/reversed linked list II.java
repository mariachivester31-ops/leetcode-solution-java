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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        // 1. Collect all the variables 
        ListNode lefprev = null;
        ListNode lef = head;

        for (int i = 1; i < left; i++) {
            lefprev = lef;
            lef = lef.next;
        }

        ListNode rig = head;
        for (int i = 1; i < right; i++) {
            rig = rig.next;
        }
        ListNode rignex = rig.next;

        // 2. Disconnect the left to right line with main line

        if (lefprev != null) {
            lefprev.next = null;
        }
        rig.next = null;

        // 3. Reverse the LtR line

        ListNode a = null;
        ListNode b = lef;

        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        // 4. Reconnect it back to main line after reversal is done 
        if (lefprev != null) {
            // Case: Reversing in the middle or end
            lefprev.next = a;
            lef.next = rignex;
            return head; 
        } else {
            // Case: Reversing from the very beginning (left = 1)
            // 'a' is the new head of the whole list
            lef.next = rignex;
            return a;
        }
    }
}
