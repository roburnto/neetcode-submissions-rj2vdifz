# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(
        self, list1: Optional[ListNode], list2: Optional[ListNode]
    ) -> Optional[ListNode]:
        # Sentinel node to simplify head handling
        dummy = ListNode()
        tail = dummy

        a, b = list1, list2
        while a and b:
            if a.val <= b.val:       # stable: prefer a when equal
                tail.next = a
                a = a.next
            else:
                tail.next = b
                b = b.next
            tail = tail.next

        # Attach the remainder (one of a or b is None)
        tail.next = a or b

        return dummy.next
