'''
Checked for conditions and all satisfied(not on leetcode)
Time - O(nlogn), space - O(1)
3 steps:
1. Declare variables
2. Iterate over the forward array and apply binary search on backward array on the remaining sum after negating forward[i] from target
3. return all the result which satisfies the condition and are
'''
def searchPairs(forward, backward, target):
    prev_Sum = 0 # assigning the latest sum to it
    result = [] # final result array
    for i in range(len(forward)):
        backIndex = binarySearch(backward, target - forward[i][1]) # binary search on backward to get the index.
        currSum = forward[i][1] + backward[backIndex][1] # get the curr sum by adding forward and backward
        if backIndex != -1: # to handle overshooting case
            if prev_Sum <= currSum:
                prev_Sum = currSum # assign curr sum to prevSum
                if prev_Sum < currSum: # if prevSum is less than curr then remove previously added elements in the result
                    result = []
                result.append([forward[i][0],backward[backIndex][0]])
    return result

def binarySearch(arr, target):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = low + (high-low)//2

        if arr[mid][1] == target:
            return mid
        elif arr[mid][1] > target:
            high = mid - 1
        else:
            low = mid + 1
    return high

forward = [[1,2000],[2,4000],[3,6000]]
backward = [[1,2000],[2,4000]]
target = 7000


# print(binarySearch(forward,9000))
print(searchPairs(forward, backward, target))