"""
The approach here is to capture the element window-wise. we keep our low at 0th index and high at len(arr)-k.
because we can have the window starting position only from len(arr)-k position onwards if the element is
towards the right-most. Now we start finding the mid, if the given x- element at mid is greater than mid+kth
index value - x, this means that a better window exsists towards our right side of mid, so we move low to 
mid+1 else it means that a better window is towards the left side of the mid, so we  move towards the left
making high to mid. we do this until we find the best window and then at last we have the starting index i.e
low and low+k elements as the best window as solution.

Time complexity - O(log n -k)
Space complexity - O(1)
Leetcode running

"""
def findClosestElements(self, arr, k, x):
        if x >= arr[-1]:
            return arr[-k:]
            
        if x <= arr[0]:
            return arr[:k]
        
        low = 0
        high = len(arr)-k 
        while low < high:
            mid = low+(high-low) // 2
        
            if x - arr[mid] > arr[mid+k] - x:
                low = mid+1
            else:
                high = mid
        return arr[low:low+k]
                