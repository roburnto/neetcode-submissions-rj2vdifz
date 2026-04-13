class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned_string = re.sub(r'[^A-Za-z0-9]', '', s)
        cleaned_string = cleaned_string.lower()

        l, r = 0, len(cleaned_string)-1
        while l < r:
            if cleaned_string[l] != cleaned_string[r]:
                return False
            l +=1
            r -=1

        return True