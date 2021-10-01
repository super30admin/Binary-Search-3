// Time Complexity :O(log(n-k)) 
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

//binary search based on starting point
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low=0;
        //as the starting to ending window lies within this length
        int high = arr.length-k;
        while(low < high){
            int mid = low + (high-low)/2;
            //if we consider mid as starting point then dist of mid from x
            int distS = x - arr[mid];
            //end point if mid is considered as starting
            int distE = arr[mid+k] - x;
            if(distS > distE)
                low = mid+1;
            else high = mid;
        }
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
