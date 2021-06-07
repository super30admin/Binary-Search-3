// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity: O(nlog(k)) - O(n) for iterating through the link lists of n elements and log(k) for heapify function
//Space Complexity: O(n) since we are using extra datastructure for storing these n elements (heap)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        for(ListNode head: lists){
            if(head != null){
               pq.add(head);   
            }
        }
        
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            curr = curr.next;
            if(min.next != null){
                pq.add(min.next);
            }
        }
        
        return dummy.next;        
    }
}