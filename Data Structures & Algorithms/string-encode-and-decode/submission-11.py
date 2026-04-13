class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s))+'#'+s
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != '#' and j < len(s):
                j+=1
            length = int(s[i:j])
            decoded = s[j+1:j+length+1]
            res.append(decoded)
            i = j + length+1
        
        return res