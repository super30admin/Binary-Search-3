// Time Complexity : O(k+logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    
    int l = 0;
    int h = arr.length - k;
        
        while(l < h){
            int mid = l+(h-l)/2;
            
            int L_B = Math.abs(x-arr[mid]);
            int R_B = Math.abs(x-arr[mid + k]);
            
            if(L_B > R_B){
                l = mid + 1;
            }else{
                h = mid;
            }
        }
        
        List<Integer> output = new ArrayList<>();
        
        for(int i = l; i < l+k; i++){
            output.add(arr[i]);
        }
        
        return output;      
    }
}
