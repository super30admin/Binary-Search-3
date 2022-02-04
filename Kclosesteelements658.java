/**
 *        Time Complexity - O(logN)
        Space Complexity - O(1)
 * */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0 ){
            return result;
        }
        int lowPointer = 0;
        int highPointer = arr.length-1;
        while(highPointer - lowPointer  + 1 > k){
        int distanceH = Math.abs(x - arr[highPointer]);
        int distanceL = Math.abs(x - arr[lowPointer]);
            if(distanceL > distanceH){
                 lowPointer++;
            }else{
               highPointer--;
            }
        }
        
        for( int i = lowPointer ; i <= highPointer; i++){
            result.add(arr[i]);
        }
        return result;
      
        
    }
}
