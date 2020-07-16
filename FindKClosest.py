class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        result = []
        low = 0
        high = len(arr) - k
        while(low < high):
            mid = low + (high - low) // 2
            distL = abs(x - arr[mid]);
            distH = abs(x - arr[mid + k])
            if(arr[mid] == arr[mid + k]):
                if(x > arr[mid]):
                    low = mid + 1;
                else:
                    high = mid;
            else:
                if(distL > distH):
                    low = mid + 1;
                else:
                    high = mid;
        
        
        for i in range(low,low+k):
            result.append(arr[i]);
        
        return result;
        
 Time is O(log(n-k))
 Space is O(1)
