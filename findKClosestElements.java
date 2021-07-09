// Time Complexity: O(log (n-k)) where n is number of elements in given array
//Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr == null || arr.length == 0) return result;
        
        int low = 0; int high = arr.length - k;
        
        while(low < high){
            int mid = low + (high - low)/2;
            int disFirst = x - arr[mid];
            int disLast = arr[mid+k] - x;
            if(disFirst > disLast) low = mid + 1;
            else high = mid;
        }
        while(k > 0){
            result.add(arr[low]);
            low++;
            k--;
        }
        
        return result;
        
    }
}

// Time Complexity: O(log n) where n is number of elements in given array
//Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result = new ArrayList<>();
        int low = 0; int high = arr.length - 1;
        
        if(arr == null || arr.length == 0) return result;
        
        while(high - low + 1 > k){
            int disL = x - arr[low];
            int disH = arr[high] - x;
            
            if(disL > disH){
                low++;
            } else{
                high--;
            }
        }
        
        while(low != high){
            result.add(arr[low]);
            low++;
        }
        result.add(arr[high]);
        return result;
    }
}