
/*
method 1 - 2 pointer
initialise ptr1 to 0 and ptr2 to length-1;
if,abs diff at p1 is > abs diff at p2, p1++, else p2--
keep doing this until p1 - p2 + 1 >k, then give the result;
time complexity: O(n)
space complexity: O(1)

method 2 - Closest binary search method
do binary search to find the closest index to element x 
and the search for k closest element which lie on either the left or right of closest index

Time complexity : O(log n + k)


*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
      
        LinkedList<Integer> result = new LinkedList<>();
        if(arr.length == 0)return result;
        
        //method 1
//         int low = 0;
//         int high = arr.length-1;
        
//         while(high-low+1 > k){
            
//             if(Math.abs(arr[low] - x) > Math.abs(arr[high] - x)){
//                 low++;
//             }else{
//                 high--;
//             }
            
//         }
        
//         for(int i = low ; i <= high; i++){
//             result.add(arr[i]);
//         }
        
        
        
        int closest = findClosestIndex(arr, x);
        
        int left = closest-1;
        int right = closest+1;
        
        result.add(arr[closest]);
        
        while(k > 1){
            if(left < 0){
                result.addLast(arr[right++]);
            }
            else if(right == arr.length){
                result.addFirst(arr[left--]);
            }
            else{
                if(x - arr[left] <= arr[right] - x){
                    result.addFirst(arr[left--]);
                }else{
                    result.addLast(arr[right++]);
                }
            }
            
            
            k--;
        }
        
        
        
        return result;
    }
    
    private int findClosestIndex(int []arr, int x){
        
        int low = 0;
        int high = arr.length-1;
        
        while(low < high){
            int mid = low +(high-low)/2;
            
            if(arr[mid] == x){
                return mid;
            }
            else if(arr[mid] < x){
                low = mid+1;
            }
            else{
                high = mid;
            }
                
        }
        
        if(low == 0){
            return low;
        }
        
        if(Math.abs(arr[low] - x) < Math.abs(arr[low-1] - x)){
            return low;
        }
            return low-1;
        
           
           
    }
}