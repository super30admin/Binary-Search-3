/*
// time - O(n) space - O(1)
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr is None or len(arr) == 0:
            return []
        result = []
        
        low = 0
        high = len(arr) - 1
        while high - low + 1 > k:
            diffL = x - arr[low]
            diffR = arr[high] - x
            
            if diffL > diffR:
                low += 1
            else:
                high -= 1
        
        while low < high + 1:
            result.append(arr[low])
            low += 1
        return result
*/
/*
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;
        
        int low = 0, high = arr.length -1;
        while (high - low + 1 > k){
            int diffL = x - arr[low];
            int diffR = arr[high] - x;
            
            if (diffL > diffR)
                low++;
            else
                high--;
        }
        
        while (low < high + 1){
            result.add(arr[low]);
            low ++;
        }
        return result;
    }
}
*/

/*
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if arr is None or len(arr) == 0:
            return []
        result = []
        
        low = self.binary(arr, 0, len(arr)-k, k, x)
        n = low + k
        while low < n:
            result.append(arr[low])
            low += 1
        return result
    
    def binary(self, arr, low, high, k, x):
        while low <= high:
            first = low + (high-low)//2
            last = first + k -1
            
            if first - 1 >= 0 and x-arr[first-1] <= arr[last] - x:
                high = first - 1
            
            elif last + 1 < len(arr) and x - arr[first] > arr[last + 1] - x:
                low = first + 1
            else:
                return first
*/
// Time Complexity : O(logn)
// Space Complexity : O(1)

// Your code here along with comments explaining your approach: I used binary search to find the correct placement for low index
// and after that just iterated till low + k 


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;
        
        int low = binary(arr, 0, arr.length - k, k, x);
        int n = low + k;
        
        while (low < n){
            result.add(arr[low]);
            low ++;
        }
        return result;
    }
    public int binary(int[] arr, int low, int high, int k, int x){
        while (low <= high){
            int first = low + (high-low) / 2;
            int last = first + k - 1;
            
            if (first - 1 >= 0 && (x - arr[first-1] <= arr[last] - x))
                high = first - 1;
            else if (last + 1 < arr.length && (x - arr[first] > arr[last+1] - x))
                low = first + 1;
            else
                return first;
        }
        return low;                                 // will never reach this line 
    }
            