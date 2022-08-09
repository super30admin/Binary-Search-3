# Time Complexity: O(n-k)
# Space Complexity: O(1)


# Two-pointer Approach
def findClosestElements(arr, k, x):
    if arr is None or len(arr) == 0:
        return []

    left = 0
    right = len(arr) - 1
    while right - left + 1 > k:
        distleft = x - arr[left]
        disright = arr[right] - x
        if distleft > disright:
            left += 1
        else:
            right -= 1

    result = []
    for i in range(left, right + 1):
        result.append(arr[i])

    return result
