"Time Complexity is O(N)"
"Space Complexity is O(K)"

#Explanation
"Initialize pointer1 = 0 and pointer2 = len(arr) - 1.
"While (pointer2 - pointer1 + 1) > k, compare distances and adjust pointer1 or pointer2.
"If abs(arr[pointer1] - x) > abs(arr[pointer2] - x), increment pointer1; otherwise, decrement pointer2.
"Return arr[pointer1:pointer2 + 1] as the closest k elements."

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pointer1 = 0
        pointer2 = len(arr)-1

        while((pointer2 - pointer1) + 1 > k):
            if (abs(arr[pointer1] - x))  > (abs(arr[pointer2] - x)):
                pointer1 = pointer1 + 1
            else:
                pointer2 = pointer2 - 1

        return arr[pointer1:pointer2+1]

        