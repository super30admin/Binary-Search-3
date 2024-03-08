// Time Complexity :O(log n)
// Space Complexity :O(log n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: using binary search we find the starting element by using variables sd and ed to find the distance and BS till n-k elements when the high meets mid that will be the right start point and from that place to k elements will be the result

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            
        int mid = low + (high - low)/2;
        int sd = x - arr[mid];
        int ed = arr[mid + k] - x;
        if(sd > ed ){
            low = mid +1;
        } else {
            high = mid;
        }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i< low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}