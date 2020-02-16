/*
 * Time complexity : O(n)
 * Space Complexity : O(1)
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0){
            return result;    
        }
        
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low+1 > k)
        {
            if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)){
                low++;
            }else{
                high--;
            }
        }
        
        for(int i=low; i<low+k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}