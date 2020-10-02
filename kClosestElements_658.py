# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your approach:
# Intuition: Trying to make the array with respect to x. We can take absolute difference of all elements from the given value of x and return the k numbers that have least difference. We can sort the difference array, first k elements will get us the answer.
# Problem would be to fetch the actual values: can be resolved by putting tuples and sort based on the first value and return output as the second value of the tuple. 

# Approach 1: Why not redefine the comparator? Add a custom comparator: Math.abs(x-a) > Math.abs(x-b)
# This would sort the given array according to our requirement and first k elements will be our answer.
# Time Complexity-> O(nlogn)

# Approach 2: Optimal Solution
# Start with a low point at 0, high starts at length-k. If we know the starting point, we can iterate k times to get the output. If x were smaller than first element, low would be our starting point and if x is greater than last element, high would be our starting point (and hence high=length-k).
# Keeping midpoint as it is in binary search, we maintain LB=abs(x-arr[mid]) and RB=abs(x-arr[mid+k])(left bound and right bound); also mid+k will always exist as we are setting high= length-k. If LB > RB, it indicates that left side is longer than right side of x in the array and hence the starting point will be further away from our x; right side will be closer to x. This will tell us where we want to move in our binary search while low<high. 

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        output = []
        low = 0
        high = len(arr)-k
        
        while low<high:
            mid = low+(high-low)//2
            L_B = abs(x- arr[mid])
            R_B = abs(x- arr[mid+k])
            
            if L_B > R_B:
                low = mid+1
            else:
                if arr[mid] == arr[mid+k]:
                    low = mid+1
                else:    
                    high = mid
                
        for i in range(low, low+k):
            output.append(arr[i])
        
        return output
        
                
            
            
             
        