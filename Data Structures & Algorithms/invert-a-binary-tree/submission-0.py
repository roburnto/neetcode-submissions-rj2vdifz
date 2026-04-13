# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        def swap(root):
            if root == None:
                return None
            
            root.left, root.right = root.right, root.left
            swap(root.left)
            swap(root.right)
            
        swap(root)
        return root