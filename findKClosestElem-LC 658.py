# Binary search solution
# Time Complexity = O(log(n - k)), where n is len of arr. We are taking higher bound as len(arr) - k
# Space Complexity = O(1)

class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        if arr == None:
            return []
        
        n = len(arr)
        # Initialising lower and higher bounds
        low = 0
        high = n - k            # Coz we are intending to return the starting index from where our result array would begin. If high = last index of array, we wont be able to access any elements post that index.
    
        
        while (low < high):
            mid = low + (high - low) // 2
            startDist = x - arr[mid]
            endDist = arr[mid + k] - x
            
            if startDist > endDist:
                low = mid + 1           # Move right
                
            else:
                high = mid              # Move left
            
        
        
        result = []
                
        for i in range(low, low + k):
            result.append(arr[i])
        
        
        return result

        

        
# Two pointer solution
# Time Complexity = O(n - k), coz we are not going through the entire arr of n elements but only going through right - left + 1

# Space Complexity = O(1)


class Solution:
    def findClosestElements(self, arr: list[int], k: int, x: int) -> list[int]:
        if arr == None:
            return []
        
        # Initializing pointers
        left = 0
        right = len(arr) - 1
        
        # Number of elements between the 2 pointers should be equal to k, for the condition to stop
        while (right - left + 1 > k):
            leftDist = abs(x - arr[left])
            rightDist = abs(x - arr[right])
            
            # If diff between x and element at left > x and element at right, we shift the left pointer as we are required to find elements closest to x
            if (leftDist > rightDist):
                left += 1
            # If its the other way round or if the diff between x and element at left == x and element at right, we move the right pointer since we want to give out ascending order, hence choose the smallest of the two
            else :
                right -= 1
        
        
        result = []
        for i in range(left, right + 1):
            result.append(arr[i])
            
        return result
                   