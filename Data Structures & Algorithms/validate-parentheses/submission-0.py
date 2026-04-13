class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        matching_bracket = {')': '(', ']': '[', '}': '{'}
        
        for char in s:
            if char in matching_bracket:  # If it's a closing bracket
                # Check if the stack is not empty and the top matches
                if stack and stack[-1] == matching_bracket[char]:
                    stack.pop()
                else:
                    return False
            else:  # If it's an opening bracket
                stack.append(char)
        
        # If the stack is empty, all brackets are matched
        return not stack