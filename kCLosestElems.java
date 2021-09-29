// Time Complexity : O(log n)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0; int high = arr.length - 1;
        while(high - low + 1 > k){ // O(n-k)
            int distL = Math.abs(arr[low] - x);
            int distH = Math.abs(arr[high] - x);
            if(distL > distH){
                low++;
            }else{
                high--;
            }
        }
        for(int i = low; i<= high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

// *****************************************
// Modified binary search: better approach!
// Time Complexity : O(log(n - k) )
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0; int high = arr.length - k;
        while(low < high){ // O(n-k)
            int mid = low + (high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS > distE){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        for(int i=low; i<low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}