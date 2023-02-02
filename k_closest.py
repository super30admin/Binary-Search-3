# Time Complexity :
# O(N)

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#We start with 2 pointers - one from the beginning and one from the end. If they are farther than the given k elements, we get them closer.
# If the difference of the first pointer element is larger than the distance of second poitner element, we increase first pointer element, otherwise, reduce the second pointer
#We do this until their distance is given k. Then we run a loop from first pointer to second pointer and extract the required elements

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        ptr1 = 0
        ptr2 = len(arr) -1
        new_list = []

        while ptr2 - ptr1 + 1 > k :
            if abs(arr[ptr1] - x) > abs(arr[ptr2] - x):
                ptr1 += 1
            else :
                ptr2 -= 1
        
        for i in range(ptr1,ptr2+1):
            new_list.append(arr[i])

        return new_list
