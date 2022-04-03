// Time Complexity : log(n) + k where n is length of array
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// fidn teh closd element and k-1 numbers on left and right of the found number
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if(arr == null || arr.length < k) return new ArrayList<>();

        int start = 0;
        int end = arr.length-1;
        int mid = start +(end-start)/2;

        while(start < end){
            mid = start + (end-start)/2;
            if(mid == start) {
                start = Math.abs(arr[start] - x) <= Math.abs(x - arr[end]) ? start : end;
                break;
            }
            else if(arr[mid] == x) {
                start = mid;
                break;
            }
            else if(arr[mid] < x ) start++;
            else end--;

        List<Integer> res = new ArrayList<>();
        res.add(arr[start]);

        int a = start-1;
        int b = start+1;

        for(int i=0; i<k-1; i++){

            if(a<0){
                res.add(arr[b]);
                b++;
            }
            else if(b >= arr.length){
                res.add(0,arr[a]);
                a--;
            }
            else if(Math.abs(x - arr[a]) <= Math.abs(x - arr[b])){
                res.add(0,arr[a]);
                a--;
            }
            else{
                res.add(arr[b]);
                b++;
            }
        }

        return res;

    }
}
