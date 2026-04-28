class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode fake = new ListNode(-1), slow = fake, fast = fake;
        fake.next = head;
        
        int len = 0;
        while(fast.next != null){   // fast REACH tail && Count len
            fast = fast.next; len++;
        }
        if(len == 0) return null;   // CHECK null
        
        k %= len;
        for(int i=0; i<len-k; i++)  // slow REACH before the rotated point 
            slow = slow.next;
        
        fast.next = fake.next;      // CONNECT
        fake.next = slow.next;
        slow.next = null;
        
        return fake.next; 
    }
}
