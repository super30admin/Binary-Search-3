"""
Approach 1: Find the distance of all the numbers in the array from x. then sort the distance then
first k elements are the answer, Need to store
TC: O(n) to find distance + O(log(n)) to sort + O(k) to get k.
Instead of sorting the distance array, sort the given array itself and then return.

Approach 2: Heap can also be used to find top k elements
TC: n log(k) for min heap

Approach 3: Get the distance array and find the minimum distance and expand in the opposite direction using
2 pointers.
TC: O(n) to find distance + O(k) 2 pointers,

Approach 4: two pointers, Get the distance array and use 2 pointers, one on 0th index and the other on
last index.
TC: O(n-k) distance could be found on the fly + O(n-k) to copy

Approach 5: binary search
Find the number. if not present, find next lower or next higher number.
Then except in the right and left direction till k numbers are found
TC: O(log(n)) + O(k), the worst case: O(n) since once bianry search it done, the expanison could be all
numbers.
Todo: find the start index of range using binary search
"""

class Solution:

    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        pq = []
        for num in arr:
            # push the current number
            if len(pq) < k:
                heapq.heappush(pq, -num)  # Use negative to simulate a max-heap
            else:
                # If the current number is smaller than the largest in the heap, replace it
                heap_top = -pq[0]  # Largest element in pq (since we use negatives)
                if num < heap_top:
                    heapq.heappop(pq)  # Remove the largest element in the heap
                    heapq.heappush(pq, -num)  # Push the current element as negative

        # Convert the heap back to positive numbers for the final top k smallest elements
        top_k_smallest = [-x for x in pq]

        return top_k_smallest[::-1]


class Solution_2pointers:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        slow, hi = 0, len(arr) - 1

        # the loop has to stop when the window size becomes k
        while (hi - slow + 1) > k:
            # find the distance between x and slow , x and hi
            slow_dis = abs(arr[slow] - x)
            hi_dis = abs(arr[hi] - x)
            # compare the 2 distances
            if slow_dis > hi_dis:
                slow += 1
            elif slow_dis <= hi_dis:
                hi -= 1
        # When the loop exits, the window between slow and hi should be of size k
        return arr[slow:hi + 1]

class Solution_bruteForce:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:

        # find distance of each integer from given number
        distance = []
        for num in arr:
            # store the absolute distance and number
            distance.append([abs(num - x), num])

        # sort based on the distance first
        distance.sort()

        first_k = []
        # store first k element, remove distance
        for k in range(k):
            first_k.append(distance[k][1])

        # sort
        first_k.sort()

        return first_k

