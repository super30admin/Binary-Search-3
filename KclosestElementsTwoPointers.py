import heapq as heap
'''Time Complexity: O(n-k)
Space Complexity: O(1)'''

class Solution(object):
            
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        if len(arr)==0:
            return []
        #Two pointers
        n=len(arr)
        start=0
        end=n-1
        #Till the gap is greated than k, keep on reducing the gap
        while end-start+1 > k :
            start_dis=abs(arr[start]-x)
            end_dis=abs(arr[end]-x)
            if start_dis > end_dis:
                start+=1
            else:
                end-=1
        
        result=[]
        for i in range(start, end+1):
            result.append(arr[i])
        return result
        
