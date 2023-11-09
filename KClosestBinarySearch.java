// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: None

// Your code here along with comments explaining your approach

class KClosestBinarySearch {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-k;
        while(low<high){
            int mid = low+(high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            if(distS>distE){
                low =mid+1;
            }
            else{
                high = mid;
            }
        }
        List<Integer> res = new ArrayList();
        for(int i=low;i<low+k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}