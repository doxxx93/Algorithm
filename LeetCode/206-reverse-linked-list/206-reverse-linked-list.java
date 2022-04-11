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
        //flip the next value as I walk through the entire linked list, then set last element to be the head. 
        //I need a temporary ListNode to be at the position of the next node in the list
        
        if(head == null){
            return head;
        }
        
        if(head.next == null){
            return head;
        }
        
        ListNode temp; //connection to list after pointer.
        ListNode curr = head.next;
        ListNode before = head; //for node behind current pointer
        before.next = null;
        
        while(curr != null){
            temp  = curr.next; //keep the rest of list in memory
            curr.next = before;
            before = curr;
            curr = temp;
        }
        
        
        return before;
        
        
    }
}