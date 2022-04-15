// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

//Two pointer Technique
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) 
            return result;
        
        int low = 0; 
        int high = arr.length - 1;
        
        while(high-low+1 > k) {
            int distL = Math.abs(x-arr[low]);
            int distH = Math.abs(x-arr[high]);
            if(distL > distH){
                low++;
            } else {
                high--;
            }   
        }
        for(int i = low; i <= high ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

//Modified Binary Search
// Time Complexity : O(log(n-k)+k)
// Space Complexity : O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) 
            return result;
        
        int low = 0; 
        int high = arr.length - k;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE){
                low = mid+1;
            } else {
                high = mid;
            }   
        }
        for(int i = low; i < low+k ; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
