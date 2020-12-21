"""
Time Complexity : O(log(n-k)) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, for this questions following 3 approaches come to my mind:
1. Find the x or the position of x using binary binary search, and using 2 pointer approach we go left and 
right to find k elements. T(O(long n + k))
2. We can use a 2 pointer approach and start from both ends. We can start calculating the distance of each
number from x and start shrinking the window, when we reach the best k, we return those numbers.
T(O(n-k))
3. This is the approach that I have followed here. We operate on n-k numbers. Set low as 0 and high as n-k,
we are doing this because, even if x is the last number, the first element of the range is n-kth number.
Now, we do binary search on this range to find the first element of the output. Everytime we find
first and last pointer according to low and high, and match their distance with the boundaries and adjust
the high and low pointers according to the results. 
"""


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        low = 0
        high = len(arr)-k
        first = self.helper(low, high, k, x, arr)
        return arr[first:first+k]

    def helper(self, low, high, k, x, arr):
        while low < high:
            first = low+(high-low)//2
            last = first+k-1
            if first > 0 and x-arr[first-1] <= arr[last]-x:
                high = first-1
            elif last < len(arr)-1 and x-arr[first] > arr[last+1]-x:
                low = first+1
            else:
                return first
        return low
