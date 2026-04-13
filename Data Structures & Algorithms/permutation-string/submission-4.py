class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        char_bag = [0]*26
        for c in s1:
            char_bag[ord(c)-ord('a')] +=1
        l = 0 
        j =len(s1)-1
        char_bag2 = [0]*26
        for c in s2[:len(s1)-1]:
            char_bag2[ord(c)-ord('a')] +=1
        
        while j < len(s2):
            char_bag2[ord(s2[j])-ord('a')] += 1
            if char_bag2 == char_bag:
                return True
            char_bag2[ord(s2[l])-ord('a')] -=1
            l+=1
            j+=1
            
        
        return False