// Time Complexity = O(n-k)
// Space Complexity = O(1)


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int low = 0 ;
        int high = n - k;
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE){
                low = mid + 1;   
            }
            else {
                high = mid;    
            }
        }
        
        for(int i = low; i < low + k; i ++){
            result.add(arr[i]);
        }
        return result;
    }
}