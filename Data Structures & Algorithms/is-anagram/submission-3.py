class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        #char count arrays
        s_count = [0]*26
        t_count = [0]*26

        for char in s:
            s_count[ord(char)-ord('a')] += 1
        
        for char in t:
            t_count[ord(char)-ord('a')] += 1

        return s_count == t_count