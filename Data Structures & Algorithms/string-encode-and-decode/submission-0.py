class Solution:

    def encode(self, strs: List[str]) -> str:
        encoded = ""
        for string in strs:
            encoded += str(len(string)) + "#" + string
        
        return encoded

    def decode(self, s: str) -> List[str]:
        res = []
        index = 0
        while(index < (len(s)-1)):
            j = index
            while s[j] != "#":
                j+=1
            length = int(s[index:j])

            index = j + 1
            j = index + length
            res.append(s[index:j])
            index = j

        return res
            

            
