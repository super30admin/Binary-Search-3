# TC : O(log(n-k) + k)
# SC : O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
            n = len(arr)
            left = 0
            right = n - k
            while (left < right) :
                mid = (left + right) // 2            
                if(arr[mid] == arr[mid + k]):       
                    if (arr[mid] < x) :
                        left = mid + 1
                    else:
                        right = mid

                elif (abs(x - arr[mid]) <= abs(x - arr[mid + k])) :
                    right = mid
                else:
                    left = mid + 1                                             
            
            return arr[left:left + k]