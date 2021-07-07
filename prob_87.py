# Could not check on leetcode
# Time - O(nlogn)
# space - O(1)

def searchPairs(forward, backward, target):
    prev_Sum = 0 #initialising sum
    result = []
    for i in range(len(forward)):
        returnindex = binarySearch(backward, target - forward[i][1]) # binary search on backward array to get the index of the optimal distance.
        currSum = forward[i][1] + backward[returnindex][1] # get the curr sum by adding forward distance and backward distance
        if prev_Sum <= currSum and currSum <= target:
            if prev_Sum < currSum : # if prev_Sum is less than curr then remove previously added elements in the result
                result = []
            result.append([forward[i][0],backward[returnindex][0]])
            prev_Sum = currSum # make the prev_sum the least of all the sums satisfied
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
backward = [[1,2000],[2,2900]]
target = 7000

print(searchPairs(forward, backward, target))