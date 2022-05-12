class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        '''
        Algorithm

Initalize two variables to perform binary search with, left = 0 and right = len(arr) - k.

Perform a binary search. At each operation, calculate mid = (left + right) / 2 and compare the two elements located at arr[mid] and arr[mid + k]. If the element at arr[mid] is closer to x, then move the right pointer. If the element at arr[mid + k] is closer to x, then move the left pointer. Remember, the smaller element always wins when there is a tie.

At the end of the binary search, we have located the leftmost index for the final answer. Return the subarray starting at this index that contains k elements.

T = O(log(N−k)+k).
Although finding the bounds only takes O(\log(N - k))O(log(N−k)) time from the binary search, it still costs us O(k)O(k) to build the final output.

Space complexity: O(1)O(1).
        '''
        # Initialize binary search bounds
        left = 0
        right = len(arr) - k
        
        # Binary search against the criteria described
        while left < right:
            mid = (left + right) // 2
            if x - arr[mid] > arr[mid + k] - x:
                left = mid + 1
            else:
                right = mid

        return arr[left:left + k]
        
        '''
        1, 2, 3, 4, 5, 6, 7, 8, 9
        x = 4 
        k = 5
        
        '''
        
        
