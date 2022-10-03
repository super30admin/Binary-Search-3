/*
Binary Search Approach
Time Complexity - O(logn-k)
Sapce Complexity - O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low = 0;
        int high = arr.length-k;
        List<Integer> result = new ArrayList<>();
        int mid;
        // binary search
        while(low<high){
            mid = low + (high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            
            if(distE<distS){
                low = mid+1;
            }
            else{
                high=mid;
            }
            
        }
        
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        
        
        return result;
    }
}
