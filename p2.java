// Time Complexity :O(log(n-k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Getting the range in which our starting number would lie
        int start = 0;
        int end = arr.length - k;
        //Using binary search to find the starting number
        while(start<end){
            int mid = start + (end-start)/2;
            //Not using absolute value to take care of edge case where all the numbers are equal except first and last element and we would have to find number closest to first or last element
            int min = x - arr[mid];
            int max = arr[mid+k] - x;
            if(min>max){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=start; i<start+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}