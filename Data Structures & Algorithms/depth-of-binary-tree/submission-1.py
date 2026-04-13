# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

        def post_dfs(root, n):
            if not root:
                return n
            
            return max(post_dfs(root.right, n+1), post_dfs(root.left,n+1))
            

        return post_dfs(root, 0)