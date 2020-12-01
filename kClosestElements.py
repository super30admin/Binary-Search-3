#Time Complexity : O(log(n-k))
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        l, h = 0, len(arr)-k

        while l < h:
            #find mid i.e. the first element of our temp range
            first = l + (h-l)//2
            #get last element of range using our mid value
            last = first + k
            #check if first element of temp range is closer to x than last element
            if x-arr[first] <= arr[last]-x:
                h = first
            else:
                l = first + 1

        #l will be our left most pointer in our range so l to l+k will give our required range
        return arr[l: l+k]
    

    #BRUTE FORCE
    # def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #     differences = []
    #     #get all the differences of the given x and numbers
    #     for num in arr:
    #         differences.append([abs(num-x),num])
    #
    #     #sort the differences array by the first value that is the difference and then return the sorted array with k elements
    #     return sorted([n for d, n in sorted(differences, key = lambda x: x[0])][:k])
