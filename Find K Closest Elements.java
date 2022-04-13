// Time Complexity :  O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    //method1 2 ptr
    //TC:O(nlogn) SC:O(1)
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int low = 0;
    //     int high = arr.length-1;
    //     while(high-low+1>k){
    //         int distL = Math.abs(x-arr[low]);
    //         int distR = Math.abs(arr[high]-x);
    //         if(distL>distR)low++;
    //         else high--;
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     for( int i=low;i<=high;i++){
    //         result.add(arr[i]);
    //     }    
    //     return result;
    // }
    
    //method2 BS
    //TC: O(log(n-k))  SC:O(1)
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;//#elements on right of high should be k so that the worst range fall on right;
        while(high>low){
            int mid = low+(high- low)/2;
            int distL = x-arr[mid];
            int distR = arr[mid+k]-x;
            if(distL>distR){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for( int i=low;i<low+k;i++){
            result.add(arr[i]);
        }    
        return result;
    }
}