# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        
        def post_dfs(root):
            if not root:
                return
            post_dfs(root.left)
            post_dfs(root.right)
            root.right, root.left = root.left, root.right
        post_dfs(root)

        return root