//Time: O(logn + k)
//Space: O(1)
//Binary Search
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0 || k == 0)
            return new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        List<Integer> result = new ArrayList<>();
        
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            
            if(distS > distE)
                low = mid + 1;
            else
                high = mid;
        }
        
        for(int i = low; i < low + k; i++)
            result.add(arr[i]);
        
        return result;
    }
}
//Time: O(n - k)
//Space: O(1)
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         if(arr == null || arr.length == 0 || k == 0)
//             return new ArrayList<>();
        
//         int left = 0;
//         int right = arr.length - 1;
//         List<Integer> result = new ArrayList<>();
        
//         while(right - left + 1 > k){
//             int distL = x - arr[left];
//             int distR = arr[right] - x;
            
//             if(distL > distR)
//                 left++;
//             else
//                 right--;
//         }
//         for(int i = left; i <= right; i++){
//             result.add(arr[i]);
//         }
        
//         return result;
        
//     }
// }
