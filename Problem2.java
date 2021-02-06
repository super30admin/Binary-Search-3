// https://leetcode.com/problems/find-k-closest-elements/
// Time complexity : 0(log(n-k))
// Space complexity : 0(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         int start = 0, end = arr.length-k;
         
         while(start<end) {
             int mid = (start + end)/2;
             if (x - arr[mid] > arr[mid+k]-x)
                 start = mid + 1;
             else
                 end = mid;
         }
 
         List<Integer> results = new ArrayList<Integer>();
         for(int i=start;i<start+k;i++){
             results.add(arr[i]);
         }
         return results;
         
     }
 }
 
