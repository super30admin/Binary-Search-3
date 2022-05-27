// Two pointer solution TC O(n) and SC O(1)
// S
class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    
        int low = 0;
        int high = arr.length -1; 
        
        while(high -low + 1 > k){
        
            int distLow = Math.abs(x - arr[low]);
            int distHigh = Math.abs(x - arr[high]);
            if(distLow > distHigh) low++;
            else high--; 
            
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
            
        }
        return result;


    }

}
