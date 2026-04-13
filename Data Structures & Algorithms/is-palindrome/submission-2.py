class Solution:
    def isPalindrome(self, s: str) -> bool:
        stripped = re.sub(r'[^a-zA-Z0-9]','',s)
        
        l,r = 0, len(stripped)-1

        while l<r:
            if(stripped[l].lower() != stripped[r].lower()):
                return False
            else:
                l += 1
                r -= 1
        
        return True
        