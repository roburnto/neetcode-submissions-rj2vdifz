class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_l1 = [0]*26
        char_l2 = [0]*26

        for c in s:
            char_l1[ord(c)-ord("a")] += 1
        for c in t:
            char_l2[ord(c)-ord("a")] += 1
        
        return char_l1 == char_l2

        