// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

/**
 * Using a two pointer approach, getting the range closest to x and then returning the range.
 * Binary search can be used as well where mid , we can get the mid and then get closest elements to x.
 */


class Problem2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-1;

        while(high-low +1 >k ){

            int left = x - arr[low];
            int right = arr[high] -x;

            if(left > right){
                low++;
            }
            else
                high--;

        }

        List<Integer> result = new ArrayList<>();

        for(int i=low; i<=high; i++){
            result.add(arr[i]);

        }

        return result;
    }
}
