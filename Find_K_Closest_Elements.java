// TC : O(n)
// SC : O(1)
// Two pointer based solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;;
        
        int n = arr.length;
        int high = n - 1;
        int low = 0;
        while(low < high) {
            
            if(high - low <= k - 1)
                break;
            
            if(Math.abs(x - arr[low]) <= Math.abs(x - arr[high]))
                high--;
            else
               low++;
        }
        while(k-- > 0) {
            result.add(arr[low]);
            low++;
        }
        
        return result;
    }
    
}
