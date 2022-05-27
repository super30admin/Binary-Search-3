// binary search on a window ,  O(\log(N - k) + k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;
        int mid =0;
        
        // Binary search against the criteria described
        while (left < right) {
            mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}




/* 

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
*/
