// Time Complexity : o(n) 
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high= arr.length-k;
        
        while(low<high){
            int mid= low + (high-low)/2;
            int startdis=x - arr[mid];
            int enddis = arr[mid+k]-x;
            
            if(startdis>enddis){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}