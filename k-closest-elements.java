// Time - O(lg N)
// Space - O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr==null||arr.length==0||k==0){
            return result;
        }
        
        
        int low = binarySearch(arr, k, x, 0, arr.length - k);
        
        for(int i=low;i<low+k;i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
    
    private int binarySearch(int[] arr, int k, int x, int low, int high) {
        while(low<=high){
            int first = low + (high - low)/2;
            int last = first + k - 1;
            
            if(first>=1 && (x-arr[first - 1] <= arr[last] - x)) {
                high = first - 1;
            }
            else if(last < arr.length - 1 && (x - arr[first] > arr[last+1]-x)){
                low = first + 1;
            }
            else {
                return first;
            }
        }
    }
}


// Time - O(N)
// Space - O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        if(arr==null||arr.length==0||k==0){
            return result;
        }
        
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low + 1 > k){
            if(x - arr[low] > arr[high] - x) {
                low++;
            }
            else {
                high--;
            }
            
        }
        
        for(int i=low;i<low+k;i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
}
