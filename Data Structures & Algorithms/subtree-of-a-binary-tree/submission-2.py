# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        
        def isEqual(p,q):
            if not p and not q:
                print("True subtree ended")
                return True
            if p and q and q.val == p.val:
                print(q.val)
                print(p.val)
                return isEqual(p.left,q.left) and isEqual(p.right, q.right)
            else:
                print("False subtree not ended")
                return False
        
        def find(root, subRoot):
            if not root:
                return False
            if isEqual(root, subRoot):
                return True
            else:
                return find(root.left, subRoot) or find(root.right, subRoot)

        return find(root, subRoot)
            

        