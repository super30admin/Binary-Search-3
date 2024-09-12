class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            int L_B = Math.abs(x - arr[mid]);
            int R_B = Math.abs(x - arr[mid+k]);
            
            if (L_B > R_B){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        
        return result;
        
    }
}