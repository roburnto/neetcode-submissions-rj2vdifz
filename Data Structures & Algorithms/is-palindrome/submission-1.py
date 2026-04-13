class Solution:
    def isPalindrome(self, s: str) -> bool:
        
        stripped_s = ''.join([char for char in s if (char.isalpha() or char.isnumeric())])

        stripped_s = stripped_s.lower()

        L,R = 0 , len(stripped_s) - 1

        while L < R:
            if stripped_s[L] != stripped_s[R]:
                return False

            L += 1
            R -= 1
        return True


        