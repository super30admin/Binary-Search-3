#Time Complexity : O(nlogn)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        differences = []
        #get all the differences of the given x and numbers
        for num in arr:
            differences.append([abs(num-x),num])

        #sort the differences array by the first value that is the difference and then return the sorted array with k elements
        return sorted([n for d, n in sorted(differences, key = lambda x: x[0])][:k])
