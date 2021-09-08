class Solution:
    """
    TC - O(n)
    SC. -   O(1)
    """
    def approach1(self, arr, k, x):
        ans = []
        lo, hi = 0, len(arr) - 1
        while hi - lo + 1 > k:
            dl = x - arr[lo]
            dr = arr[hi] - x
            if dl > dr:
                lo += 1
            else:
                hi -= 1
        return [arr[i] for i in range(lo, hi + 1)]

    """
    TC - O(logn) + O(k)
    SC. -   O(1)
    """
    def approach2(self, arr, k, x):
        ans = []
        lo, hi = 0, len(arr) - 1
        while hi - lo + 1 > k:
            dl = x - arr[lo]
            dr = arr[hi] - x
            if dl > dr:
                lo += 1
            else:
                hi -= 1
        return [arr[i] for i in range(lo, hi + 1)]

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        # return self.approach1(arr,k,x)
        low, high = 0, len(arr) - k
        while low < high:
            mid = low + (high - low) // 2
            dl = x - arr[mid]
            dh = arr[mid + k] - x
            if dl > dh:
                low = mid + 1
            else:
                high = mid
        return [arr[i] for i in range(low, low + k)]
