# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    """Reverse LL using recursion
    Time complexity-O(n)
    Space complexity-O(n)"""
    def reverseList(self, head: ListNode) -> ListNode:
        dummy=head
        if not head:
            return 
        result=self.reverse(dummy)
        return result
        
    def reverse(self, head):
        if not head.next:
            return head
        reversedNode=self.reverse(head.next)
        head.next.next=head
        head.next=None
        return reversedNode
            
        