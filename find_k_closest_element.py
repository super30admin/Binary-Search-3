# Approach 1: Two Pointer Linear Approach
# -----------------------------
# Shrink the window [i, j] from both ends until the window size becomes k.
# At each step, remove the element (either from the start or the end) that is farther from x.
# In case of a tie in distance, remove the larger element to prioritize smaller ones.
#
# Time Complexity: O(n - k), where n = len(arr)
# Space Complexity: O(1), as we use only two pointers

# Approach 2: Max Heap Approach
# -----------------------------
# Use a max heap to keep track of k closest elements.
# Push negative of difference and value to simulate max heap using Python's min-heap.
# If heap size exceeds k, remove the farthest element (the root).
# Return the sorted version of collected k elements.
#
# Time Complexity: O(n * log k)
# Space Complexity: O(k), for the heap

# Approach 3: Binary Search + Two Pointer Expansion
# -------------------------------------------------
# First use binary search to find the closest or insertion point for x.
# Then expand two pointers (left, right) around this point to collect k closest elements.
#
# Time Complexity: O(log n + k)
#   - log n for binary search
#   - k for expanding to collect elements
# Space Complexity: O(1)

import heapq

class Solution:
    def findClosestElements_linear(self, arr, k, x):
        i, j = 0, len(arr)-1
        while (j-i+1) != k:
            ith = abs(arr[i] - x)
            jth = abs(arr[j] - x)
            if ith < jth:
                j -= 1
            elif ith > jth:
                i += 1
            else:
                if arr[i] < arr[j]:
                    j -= 1
                else:
                    i += 1
        return arr[i:j+1]
    
    def findClosestElements_maxHeap(self, arr, k, x):
        maxHeap = []
        for num in arr:
            diff = abs(x - num)
            heapq.heappush(maxHeap, (-diff, -num))
            if len(maxHeap) > k:
                heapq.heappop(maxHeap)
        res = []
        while maxHeap:
            pop = heapq.heappop(maxHeap)
            res.append(pop[1] * -1)
        return sorted(res)
    
    def findClosestElements_BinarySearch(self, arr, k, x):
        i,j = 0, len(arr)-1
        right = float('-inf')
        while i <= j:
            mid = (i+j)//2
            if arr[mid] == x:
                right = mid
                break
            elif arr[mid] < x:
                i = mid + 1
            else:
                j = mid -1 
        right = i if right == float('-inf') else right
        left = right - 1
        while right - left - 1 < k:
            if left < 0:
                right += 1
            elif right >= len(arr):
                left -= 1
            elif abs(x - arr[left]) <= abs(x - arr[right]):
                left -= 1
            else:
                right += 1
        return arr[left+1: right]

def main():
    arr = [1, 2, 3, 4, 5]
    k = 4
    x = 3

    sol = Solution()

    print("Linear Two Pointer Approach:")
    print(sol.findClosestElements_linear(arr.copy(), k, x))

    print("\nMax Heap Approach:")
    print(sol.findClosestElements_maxHeap(arr.copy(), k, x))

    print("\nBinary Search + Expansion Approach:")
    print(sol.findClosestElements_BinarySearch(arr.copy(), k, x))

if __name__ == "__main__":
    main()