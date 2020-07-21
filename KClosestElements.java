
//Binary Search approach
//Time Complexity  : O(logn)
//Space Complexity: O(1);
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     
        if(arr == null || arr.length ==0 )
            return new ArrayList<Integer>();
        
        List<Integer> output  = new ArrayList<>();
        int low =0 ;
        int high = arr.length - k;
        while(low < high){
            int mid = low + (high  - low)/2;
            if( x-arr[mid]  >  arr[mid+k]-x)
              low = mid+1;
            else
                high = mid;
        }
       
        for(int i = 0; i < k ;i++){
            output.add(arr[low]);
            low++;
        }
        return output;
    }
}





