class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_map = Counter(nums)
        count_map = dict(count_map)

        top_k = sorted(count_map.items(), key = lambda item: item[1], reverse = True )[:k]

        top_k_keys = [key for key, count in top_k]

        return top_k_keys
