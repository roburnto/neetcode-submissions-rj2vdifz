class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        ana_map = defaultdict(list)

        for s in strs:
            chars = [0]*26
            for c in s:
                chars[ord(c)-ord('a')] += 1
            char_tuple = tuple(chars)
            ana_map[char_tuple].append(s)
        
        return list(ana_map.values())
        