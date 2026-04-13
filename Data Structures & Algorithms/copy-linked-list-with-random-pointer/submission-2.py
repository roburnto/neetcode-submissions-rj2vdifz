"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return head
        bope = {}
        curr = head
        while curr:
            dummy = Node(curr.val,None,None)
            bope[curr] = dummy
            curr = curr.next
        
        curr = head

        while curr:
            dummy = bope[curr]
            if curr.next:
                dummy.next = bope[curr.next]
            else:
                dummy.next = None
            
            if curr.random:
                dummy.random = bope[curr.random]
            else:
                dummy.random = None
            
            curr = curr.next

        return bope[head]