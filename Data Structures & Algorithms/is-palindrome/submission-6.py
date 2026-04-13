class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned_s = re.sub(r'[^a-z0-9]', '', s.lower())
        l,r = 0, len(cleaned_s)-1
        while l < r:
            if cleaned_s[l] != cleaned_s[r]:
                return False
            l +=1
            r -=1
        return True