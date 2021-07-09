class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        """
        optimised 
        KeyIdea : put high pointer at len(arr) -k and low at zero. keep moving pointers according to distance to get starting index of closest elements
        TC: nlog(n-k)
        """
        if x<arr[0]:
            return arr[0:k]
        if x>arr[len(arr)-1]:
            return arr[len(arr)-k:len(arr)]
        low = 0
        high = len(arr)-k
        
        while low < high:
            mid = low + (high - low)//2
            left_i = abs(x - arr[mid])
            right_i = abs(x - arr[mid+k])
            if left_i > right_i:
                low = mid + 1
            else:
                if arr[mid] == arr[mid+k]:
                    low = mid + 1
                else:
                    high = mid
        # low pointing to starting index of k closest elements   
        return arr[low:low+k]

      
        

        # """
        # Not optimised 
        # KeyIdea : put two low and high pointers at starting and ending index and get starting index at low
        # TC: nlogn 
        # """
        # if x<arr[0]:
        #     return arr[0:k]
        # if x>arr[len(arr)-1]:
        #     return arr[len(arr)-k:len(arr)]
        # low=0
        # high=len(arr)-1
        
        # while high-low+1 > k:
        #     mid = low + (high-low) // 2
        #     left_dist=x-arr[low]
        #     right_dist = arr[high]-x
        #     if left_dist> right_dist:
        #         low+=1
        #     else:
        #         high-=1
        # return arr[low:low+k]

        # # other soln
        # # fail to pass some test cases since map contains unique keys and there might be same distances for some elements

        # if x<arr[0]:
        #     return arr[0:k]
        # if x>arr[len(arr)-1]:
        #     return arr[len(arr)-k:len(arr)]

        # # key as distance value as element
        # mapp={}
        # for i in range(len(arr)):
        #     mapp[abs(arr[i]-x)]=arr[i]
        # print(mapp)
        # di=collections.OrderedDict(sorted(mapp.items()))
        # li=list(di.values())
        # return li[0:k]
        
      
        