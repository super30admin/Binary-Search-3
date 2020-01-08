
// Time Complexity : Two pointer + Binary Search O(log N) where N size of array
// Space Complexity : O(1) iterative 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        //base case
        if(arr==null || arr.length==0){
            return result;
        }
        if(arr.length==1){
            result.add(arr[0]);
            return result;
        }
        int left = 0;
        int right = arr.length-k; //!important
        //O(logN)
        
        while(left<right){ //Not equals
            int mid = left + (right-left)/2;
            int diffL = Math.abs(arr[mid]-x);
            int diffR = Math.abs(arr[mid+k]-x);
            
            if(diffL > diffR){
                left = mid+1;
            }
            else{
                right = mid;
            }    
        } //O(k)
        
        /* Just adding to result */
        for(int i=left; i<left + k ; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}


/*
Two pointer only logic : O(N)

int left = 0;
        int right = arr.length-1;
        
        while(right-left+1 > k){
            int diffL = Math.abs(arr[left]-x);
            int diffR = Math.abs(arr[right]-x);
            if(diffL>diffR){
                left++;
            }
            else{
                right--;
            }
        }
        
        for(int i=left; i<=right; i++){
            result.add(arr[i]);
        }
        

*/
