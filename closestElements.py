from typing import List


def findClosestElements(arr, k, x):
    left, right = 0, len(arr) - k
    
    while left < right:
        mid = (left + right) // 2
        if x - arr[mid] > arr[mid + k] - x:
            left = mid + 1
        else:
            right = mid
    
    return arr[left:left + k]

arr = [1,2,3,4,5]
k = 4
x = 3
print(findClosestElements(arr,k,x))

#time = O(log(n−k)+k), where n is the length of the array.
