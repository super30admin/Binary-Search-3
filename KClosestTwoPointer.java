// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

// Your code here along with comments explaining your approach

class KClosestTwoPointer {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       int left = 0;
       int right = arr.length-1;
       while(right-left>=k){
           int distL = Math.abs(arr[left] - x);
           int distR = Math.abs(arr[right]-x);
           if(distL > distR){
               left++;
           }
           else{
               right--;
           }
       }
       List<Integer> result = new ArrayList();
       for(int i=left;i<=right;i++){
           result.add(arr[i]);
       }
       return result;
    }
}