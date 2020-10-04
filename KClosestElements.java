// Time Complexity : O(logn) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int l =0;
        int h = arr.length-k;
        
        while(l<h){
            int mid = l+(h-l)/2;
            int ld = Math.abs(x-arr[mid]);
            int hd = Math.abs(x-arr[mid+k]);
            
            if(ld>hd){
                l=mid+1;
            }else
            {
                if(arr[mid]==arr[mid+k]){
                    l=mid+1;
                }else{
                    h=mid;
                }
            }
        }
        
        List<Integer> output = new ArrayList<>();
        
        for(int i=l;i<l+k;i++){
            output.add(arr[i]);
        }
        return output;
    }
}