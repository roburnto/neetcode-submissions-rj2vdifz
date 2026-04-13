class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        ana_map = defaultdict(list)

        for s in strs:
            char_count = [0]*26
            for c in s:
                char_count[ord(c)-ord('a')] += 1
            
            ana_map[tuple(char_count)].append(s)

        return list(ana_map.values())