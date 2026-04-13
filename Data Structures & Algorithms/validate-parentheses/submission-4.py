class Solution:
    def isValid(self, s: str) -> bool:
        close_to_open = {'(':')', '{':'}', '[':']'}
        stack = []

        for c in s:
            if c in close_to_open:
                stack.append(c)
            elif stack and close_to_open[stack[-1]] == c:
                stack.pop()
            else:
                return False

        
        return stack == []