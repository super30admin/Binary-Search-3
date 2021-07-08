//TC: O(log(n-k))
//SC: O(1)

// Trying to find the starting element of the range through BS
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return res;
        
        int low = 0;
        int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            int difF = x - arr[mid];
            int difL = arr[mid+k] - x;
            
            if(difF > difL)
                low = mid+1;
            else
                high = mid;
        }
        
        for(int i=low; i<low+k; i++){
            res.add(arr[i]);
        }
        
        return res;
        
    }
}