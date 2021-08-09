class Solution:

    def findClosestElements(self, arr, k, x) :

        result = []
        #### two pinters approach
        if arr == None or len(arr) == 0:
            return result
        low = 0
        high = len(arr) - 1
        while (high - low + 1) > k:
            disL = x - arr[low]
            disR = arr[high] - x

            if disL > disR:
                low += 1
            else:
                high -= 1
        for i in range(low, high + 1):
            result.append(arr[i])

        return result

        #### range binary search
        # base
        if arr == None or len(arr) == 0:
            return result

        # logic
        low = 0
        high = len(arr) - k

        while low < high:
            mid = (low + high) // 2

            disL = x - arr[mid]
            disR = arr[mid + k] - x

            if disL > disR:
                low = mid + 1
            else:
                high = mid

        for i in range(low, low + k):
            result.append(arr[i])
        return result