# Two poniter approach
# TC: O(n) ~ n-k
# SC: O(1)
# We start low and high pointers at ends of the array. We find abs diff between low pointer index value and x, same with high pointer. If left value is more: move left pointer else right pointer (Given: if abs values at both ends equal consider lower index). At the end take values lying between [low, high] inc low & high*
class Solution:
    def findClosestElements(self, arr, k, x):
        result = []
        # edge
        if not arr: return result
        low, high = 0, len(arr) - 1
        while high-low+1 > k:
            distL = abs(x - arr[low])
            distR = abs(x - arr[high])
            if distL > distR:
                low += 1
            else:
                high -= 1
        for i in range(low, high+1):
            result.append(arr[i])

        return result

# Binary search
# TC: O(logn + k)
# SC: O(1)
# Step 1:
# We find the closest number to given number: O(logn), Motive is to find the slightly higher element index. 
# a. At the end we check if low == 0(When x is lower than the first element of array)
# b. low divides array in to lower than x and higher than x(low is first element of higher side). We check the slightly lower value if it is more closer than the low element. 
# Step 2: Expand around closest element up until k elements are formed.
class Solution:
    def findClosestElements(self, arr, k, x):
        result = []
        # edge
        if not arr: return result
        closest = self.binarySearch(arr, x)
        result.append(arr[closest])
        left = closest -1
        right = closest + 1
        while k > 1:
            if left < 0:
                result.append(arr[right])
                right += 1
            elif right == len(arr):
                result.insert(0, arr[left])
                left -= 1
            else:
                if x - arr[left] > arr[right] - x:
                    result.append(arr[right])
                    right += 1
                else:
                    result.insert(0, arr[left])
                    left -= 1
            k-=1
        return result
    
    def binarySearch(self, arr, x):
        low, high = 0, len(arr) - 1
        while low < high:
            mid = low + (high - low)//2
            if arr[mid] == x: return mid
            elif arr[mid] < x:
                low = mid + 1
            else:
                high = mid
        if low == 0: return low
        if abs(arr[low] - x) < abs(arr[low-1]-x): return low
        return low - 1

