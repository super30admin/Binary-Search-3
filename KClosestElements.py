'''
    Time Complexity:
        O(n - k) (where n = length of the given array)

    Space Complexity:
        O(1)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Two pointers.
        Maintain a window of k elements.
'''

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        low = 0
        high = len(arr) - 1

        while high - low + 1 > k:
            distL = abs(x - arr[low])
            distR = abs(x - arr[high])

            if distL > distR:
                low += 1
            else:
                high -= 1

        return arr[low:high+1]
