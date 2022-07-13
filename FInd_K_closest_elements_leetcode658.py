class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        # modified Binary search TC = O(log(n-k)) because Bin Search is apllied for low = 0 to high = n-k

        n = len(arr)
        low = 0
        high = n - k  # because if x = arr[high] then next k elements may all be right of high. ie. n-k+k
        # return arr[high:high+k]
        while low < high:
            mid = low + (high - low) // 2
            dist_start = x - arr[mid]
            dist_end = arr[mid + k] - x
            if dist_start > dist_end:
                low = mid + 1
            else:
                high = mid
        return arr[low:low + k]

    '''
        # 2 pointer TC O(n-k)
        n = len(arr)
        l = 0
        r = n-1
        while r-l+1 >k:
            dist_l = abs(arr[l]-x)
            dist_r = abs(arr[r]-x)
            if dist_l > dist_r:
                l += 1
            else: # dist_l <= dist_r
                r -= 1
        return arr[l:r+1]
    '''

    '''
        # Binary Search and Sliding window TC - (O(logn) + k), SC - O(1)
        # Base
        if len(arr) == k:
            return arr

        # find the closest element and initialize two pointer
        # in interview make your binary search function insrtead of bisect_left???
        left = bisect_left(arr,x) -1   # O(logn)
        right = left + 1

        while right - left -1 < k:  # O(k)
            # Be careful to not go out of bounds
            # expand window towards side with the closer number
            if left == -1: # the k elements are found at starting of arr
                #right += 1
                #continue
                return arr[0:k]

            elif right == len(arr) : # the k elements are found at end of arr
                #left -= 1
                #continue
                return arr[right-k:right]

            if abs(arr[left] -x) <= abs(arr[right] -x):
                left -= 1
            else:
                right += 1

        return arr[left + 1 : right]
    '''

    '''
        # Brute force TC - O(nlogn + klogk) +  SC = O(n)
        #abs_arr = [(abs(x-arr[i]),arr[i]) for i in range(len(arr))]
        #abs_arr.sort()
        abs_arr = sorted(arr,key= lambda a : abs(x-a))

        result = []
        for i in range(k):
            result.append(abs_arr[i])
            #result.append(abs_arr[i][1])

        return sorted(result)
    '''