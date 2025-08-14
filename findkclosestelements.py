# Time Complexity: O(log(n-k))+O(k)
# Space Complexity:O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        n = len(arr)
        low = 0
        high = n - k
        result = []

        while low < high:
            mid = (low + high) // 2
            dis_start = x - arr[mid]
            dis_end = arr[mid + k] - x

            if dis_start > dis_end:
                low += 1
            else:
                high -= 1

        for i in range(low, low + k):
            result.append(arr[i])

        return result


