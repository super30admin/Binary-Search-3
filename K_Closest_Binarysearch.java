/*
 * Time complexity : O(log n)
 * Space complexity : O(1)
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0)
        {
            return result;
        }
        
        int low = 0;
        int high = arr.length-k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(Math.abs(arr[mid] - x) > Math.abs(arr[mid+k] - x)){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        
        for(int i=low; i<low+k; i++){
            result.add(arr[i]);
        }
        
        return result;
    }
}