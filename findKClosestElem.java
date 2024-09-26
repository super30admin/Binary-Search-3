// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach
//The idea is to keep a window range of size k which is nearer to x.
//How to find the start of the window? We use binary search
//Since, window size will be k and our goal is to find the start index, we take the maximum high as n-k.
//Then we compute the mid. Then we find whether x - arr[mid] > arr[mid+k] - x, if yes then this means our mid is way farther than x.
//So we lower down our start to mid + 1.
//Else, high = mid (mid+k-k-1).

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
 
            List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length * k == 0){
            return res;
        }
        int n = arr.length;
                
        int low = 0, high = n - k;
        while(low < high){
            int mid = low + (high-low)/2;
            if(x - arr[mid] > arr[mid+k] - x){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        for(int i = 0; i < k; i++){
            res.add(arr[i+low]);
        }
        
        return res;
    }
}