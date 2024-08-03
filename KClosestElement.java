// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
class KClosestElement {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = arr.length-1;

        while(end-start+1 > k) {
            int startDist = x - arr[start];
            int endDist = arr[end] - x;
            if(startDist > endDist) {
                start++;
            } else {
                end--;
            }
        }

        for(int i = start; i<=end; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}