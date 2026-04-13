class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])



        def dfs(i,r,c):
            if i >= len(word):
                return True
            if r >= rows or r < 0 or c >= cols or c < 0 or word[i] != board[r][c]:
                return False
            else:
                board[r][c] = '#'
                res = (dfs(i+1, r+1, c) 
                    or dfs(i+1, r, c+1) 
                    or dfs(i+1, r-1, c) 
                    or dfs(i+1, r, c-1))
                board[r][c] = word[i]
                return res

        for r in range(rows):
            for c in range(cols):
                if dfs(0,r,c):
                    return True

        return False