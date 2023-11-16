/* Time Complexity : O(n-k) + O(k) = O(n) */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Two pointer

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while(right - left >= k){// till there are k ele b/n right and left
            int distL = Math.abs(arr[left] - x);
            int distR = Math.abs(arr[right] - x);
            //Move the pointer where dist. is more
            if(distL > distR){
                left++;
            }
            else{
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        //from curr left to right add ele to result
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }
        return result;
    }
}