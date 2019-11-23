# time complexity: max(O(k,logn)
# leetcode:accepted
# space complexity:o(1)
# explaination:
# we are using binary search method.
# first we are initaising k points lesser than the last so low and high has enough
# place to move arounf without getting out of index error

# then finding the difference of the middle index with the target and middle index + kth element with the target. Which ever side is smaller we move the other pointer towards it.

# rememeber the difference should be minimum

# we do it until low<=high

# once we come out from while loop, we add low to low+k items to the resultant list and return it


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # initialise your variables
        noE = k
        target = x
        low = 0
        result = []
        high = len(arr) - noE - 1
        while (low <= high):
            mid = (low + high) // 2
            if abs(arr[mid] - target) <= abs(arr[mid + noE] - target):
                high = mid - 1
            else:
                low = mid + 1

        for i in range(0, noE):
            result.append(arr[low + i])
        return result