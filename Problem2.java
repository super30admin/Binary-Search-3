// Time Complexity : O(n Log (n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Two pointers, one at start and one at end. 
 * If the distance between the element on the left and x is greater, then move left towards end, else move right towards start. 
 * If the distance between left and right pointers is equal to k, stop and put all the elements into another array. 
 */


public class Problem2 {
        public List<Integer> findClosestElements(int[] arr, int k, int x) 
    {
        int n = arr.length; 
        int l = 0; 
        int r = n-1;
        List<Integer> result = new ArrayList<>();
        while(r-l >= k){
            int distL = Math.abs(arr[l] - x);
            int distR = Math.abs(arr[r] - x);
            if(distL > distR){
                l++;
            }
            else{
                r--;
            }
        }
        for(int i = l; i <= r; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
