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
            while j <len(s) and s[j] != '#':
                j+=1
            print(s[i:j])
            length = int(s[i:j])
            j += 1  # skip '#'
            # read the next 'length' characters
            res.append(s[j:j + length])
            # advance to start of next token
            i = j + length

        return res            