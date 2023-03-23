#Time Complexity : O(logN)+O(k), N being length of array.
#Space Complexity : O(1).
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : I had to debug some issues, but no major stucks. 
#Your code here along with comments explaining your approach in three sentences only
'''Using binary search, find the index of the closest value to x. Then, using two-pointer, 
increase the range till equal to k. 
'''
class Solution:
    def binary_search(self, begin, end, arr, x):
        #base case. 
        if end-begin<=1:
            if abs(arr[end]-x)==abs(arr[begin]-x):
                return begin
            elif abs(arr[end]-x)<abs(arr[begin]-x):
                return end
            else:
                return begin
        else:
            #cut in half the range each recursion. 
            mid = int((end+begin)/2)
            if arr[mid]>x and arr[mid+1]>x:
                return self.binary_search(begin, mid, arr, x)
            elif arr[mid]<x and arr[mid+1]<x:
                return self.binary_search(mid, end, arr, x)
            else:#arr[mid]<x and arr[mid+1]>x
                if abs(arr[mid]-x)==abs(arr[mid+1]-x):
                    return mid
                elif abs(arr[mid]-x)<abs(arr[mid+1]-x):
                    return self.binary_search(begin, mid, arr, x)
                else:
                    return self.binary_search(mid, end, arr, x)

    def two_pointer(self, index_begin, index_end, arr, k, x):
        #base case. 
        if (index_end-index_begin)-1>=k:
            return [index_begin, index_end]
        elif index_begin<0 and index_end>=len(arr):
            return [index_begin, index_end]
        else:
            #use recursion for the next step. 
            if index_begin<0:
                index_end = index_end + 1
            elif index_end>=len(arr):
                index_begin = index_begin - 1 
            else:
                if abs(arr[index_end]-x)==abs(arr[index_begin]-x):
                    index_begin = index_begin-1
                elif abs(arr[index_end]-x)<abs(arr[index_begin]-x):
                    index_end = index_end+1
                else:
                    index_begin = index_begin-1
            return self.two_pointer(index_begin, index_end, arr, k, x)


    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #call binary search and two pointer functions.
        index_closest = self.binary_search(0, len(arr)-1, arr, x)
        indices = self.two_pointer(index_closest, index_closest, arr, k, x)
        #copy values between indices into result and return. 
        result = []
        for i in range(indices[0]+1, indices[1]):
            result.append(arr[i])
        return result