'''
Time Complexity = O(log n) for binar search and O(n) for 2 pointers
Space Complexity = O(1)

Works on Leetcode
'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #Using 2 pointers
        # low, high = 0, len(arr)-1 #take 2 pointers one at start, one at end of array
        # result = []
        # while high-low >=k: #ensure distance between them is at least k 
        #     distL = abs(x-arr[low]) #calculate distance between element and low pointer
        #     distH = abs(arr[high]-x) #calculate distance between element and high pointer
        #     if distL > distH: #if left distance is higher move the low pointer towards right
        #         low+=1
        #     else: #else move the right pointer to the left
        #         high-=1
        # for i in range(low,high+1): #once we find the exact poistions iterate between them and return the result
        #     result.append(arr[i])


        result = []

        #Using Binary Search
        #In this case the mid element will actually be the first among the k elements 
        low, high = 0, len(arr) - k #the low will point to 0 but the high will point to k position from last element because
        # it is the last position where we can get at least k elements till the end of the array
        while low < high:
            mid = low + (high - low)//2 #calculate mid
            distS = x - arr[mid] #get the left distance as distance between the given element and element at mid
            distE = arr[mid+k] - x #get the right distance as distance between kth element from mid and given element
            if distS > distE: #now check which of the distance is greater and move mid accordingly
                low = mid + 1
            else:
                high = mid
        return arr[low:low+k] #at the end return only the elements between the low and kth position from low.
            

        

        