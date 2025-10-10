class Solution(object):
    # tc : O(log(n-k) + O(k))-> O(log(n-k)), binary search performed until n-k start positions -> O(log(n-k)), slicing the window takes O(k)
    # sc : O(1) no extra space used 
    def findClosestElements(self, arr, k, x):
        
        # since we know that our arr is sorted, k closest elemenst wil also be in the contiguous subarray 
        # so the target is to find where to start the subarray, there could 0,1,2,...n-k possibilitis of the start 
        # we can do binary search to find, the start if x- arr[mid] <= arr[mid+k] - x means this is one of the optimal window ( x lies in this range and this window has closest) 
        # or we can also get an optimal if we move further left { as given in the case of equal then we should choose a<b}
        # if not x- arr[mid] > arr[mid+k] - x, then our window is not right its right side of the windoe we should move
        # our output will be form arr[low:low+k] which are the closest elements to x 

        n = len(arr)
        low = 0 
        high = n-k # n-k represent the last valid slicind window start position ( as need k elemnts in our window)

        while low < high: # low is the start window pointer
            mid = low + (high-low)//2
            disStart = x - arr[mid]
            disEnd = arr[mid+k] - x

            if disStart <= disEnd:
                high = mid 
            else :
                low = mid+1
        
        return arr[low:low+k]







    
