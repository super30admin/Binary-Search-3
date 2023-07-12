#Time complexity is: O(log(n-k))
#Space complexity is: O(k)
#Code ran successfully on leet code
#No issues faced while coding
class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        #Taking low and high pointers position
        low=0
        high=len(arr)-k
        #checking the while loop condition
        while(low<high):
            #Finding the mid value
            mid=low+(high-low)/2
            #Calculating distS and distE
            distS=x-arr[mid]
            distE=arr[mid+k]-x
            #Based ion the below conditions, position of low and high will be altered
            if(distS>distE):
                low=mid+1
            else:
                high=mid
        #Creatind an empty result list for the output
        result=[]
        #Appending all the value from low to low+k in the reuslt arary
        for i in range(low,low+k):
            result.append(arr[i])
        #We are returning the reuslt
        return result


