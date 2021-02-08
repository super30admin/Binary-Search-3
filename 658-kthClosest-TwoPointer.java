/**LC-658
 * Time Complexity : O(N-k) 
 * Space Complexity : O(1)    since we will be returning list result so it wont be counted in the auxiliary space 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 Algorithm: this solution works for the duplicates as well 
 Here what we do use low and high pointers. We increment and decrement till we find a range of
 length k. So stopping condition would be high - low + 1 != k.
 We find the differences of x and arr[i]. At both the low and high pointers we compare
 these differences. If both are same, we decrement the high pointer(condition given in question)
 if the difference at a particular pointer is higher, we will decrement that pointer.
 
 */

 *
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low + 1 != k){
            
            int distL = Math.abs(x - arr[low]);
            int distH = Math.abs(x - arr[high]);
            if(distL == distH){
                
                high = high - 1;
            }
            else if(distL < distH){
                high = high - 1;
            }
            else{
                low = low + 1;
            }
            
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i <= high; i++){
            
            result.add(arr[i]);
        }
        
        return result;
    }
}