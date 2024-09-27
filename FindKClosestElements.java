// Time Complexity : O(logN + k ) - As we perform binary search and iterate through the array only for k elements
// Space Complexity : O(N) - as we use a ArrayList to store elements and perform operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> arr1 = new ArrayList<>();
         for(int n : arr){
            arr1.add(n);
        }
      if( x <= arr1.get(0)){
          return arr1.subList(0,k);
      }
      else if( x >= arr1.get(arr1.size() - 1)){
          return arr1.subList(arr1.size() - k,arr1.size());
      }
        else{
            int m = Collections.binarySearch(arr1,x); 
            if(m < 0){
                m = -m - 1;
            }
            int low = Math.max(0,m - k - 1);
             int high = Math.min(arr1.size() - 1,m + k - 1);
            while(high - low > k - 1){
                if(low < 0 || (x - arr1.get(low)) <= (arr1.get(high) - x)){
                    high--;
                }
                else if(high > arr1.size() - 1 || (x - arr1.get(low)) > (arr1.get(high) - x)){
                    low++;
                }
            }
            return arr1.subList(low,high + 1);
        }

    }
}
// Your code here along with comments explaining your approach