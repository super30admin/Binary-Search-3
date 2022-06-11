'''
Time Complexity : 0(log(n))
Space Complexity: None

Solution Approach:

Sorting Approach:
1. Calculate the difference at every index and sort them
2. Pick the smallest k count 

Heap Approach
1. Use max heap of size k and extract max if you threshold is breeched

2-Ptr Approach
1. Maintain a lft and rt ptr and move those ptr only if the value of either case exceed one another
2. Stop as soon as you get distance = k b/w lft and rt ptr

Binary Search
1. Binary search to get x 
2. Store the minimum difference and the corresponding INDEX
3. Incase of breech, stop
4. From INDEX start lftPtr and rtPtr and chk the neighbours

Binary Search to find the startingIndex of the range
(Most Optimal)
1. Low will be 0 and High will be (len(arr)-k)
2. Compare arr[mid] and arr[mid+k] results and update the 'low' and 'high' ptr acc.
3. On breech, you get the potential startPtr
4. Result will be arr[startPtr:startPtr+k]

'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        
        # perform binarySearch to find the start of my range
        low = 0
        high = len(arr)-k
        
        # binary search the list to find the "potential-start"
        while low < high:
            
            # find mid
            mid = (high-low)//2 + low
            
            #  chk if this can be the potential start of the range
            diffStart = x-arr[mid]
            diffEnd = arr[mid+k]-x # mid+k because its the end of range
            
            # compare
            if diffStart <= diffEnd:
                # go-towards lhs of the list
                high = mid
            
            else:
                # go-towards rhs of the list
                low = mid+1
            
            continue
        
        '''end of loop'''
        
        return arr[low:low+k]