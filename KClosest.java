// Time Complexity : 
/*                     APPROACH 2: USE BINARY SEARCH : O(log n) Binary Search where n is the number of elements of the array
                       APPROACH 1: USE TWO POINTERS : O(n) where n is the number of elements of the array
// Space Complexity : O(1) in both approaches
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : BS wont work for duplicates
/* Your code here along with comments explaining your approach: In approach 2, find the middle element. See the distance between x and the middle
element on whether the element is far from x or closer to x. If it is far then move the low pointer after mid else move the high pointer before mid.
Similarly, approach 1 follows two pointers where check the distance between x and the number at low and number at high, the one that is far away from
x, move that elements pointer closer to x. if the distances are equal, move the high pointer since we give preference to smallest element. We fix the
window to k by this approach and display the result
*/

// APPROACH 1 : TWO POINTERS
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || arr.length  == 0){return result;}
        int low = 0, high  = arr.length-1;
        while(high - low + 1 > k){                                                                  // while the window size is greater
            int d1 = Math.abs(x - arr[low]);                                                        // x - element at low
            int d2 = Math.abs(x - arr[high]);                                                       // x - element at high
            if(d1 > d2){
            low++;                                                                                  // far from x move low
                } else{
            high--;                                                                                     // high is far 
                }
        }
        for(int i = low; i < low + k; i++)                                                          // Got the window
            result.add(arr[i]);
        return result;
    }
}

// APPROACH 2 : BINARY SEARCH
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if(arr == null || arr.length  == 0){return result;}
        int low =0, high = arr.length-k;
        while(low < high){
           int mid = low + (high - low)/2;
           int d1 = Math.abs(x - arr[mid]);                                                         // mid is distant from x
           int d2 = Math.abs(x - arr[mid + k]);                                                     // the window would have been mid + k, how far from x
           if(d1 > d2){
               low = mid + 1;                                                                       //mid is far, move low to right
           } else { 
               high= mid;                                                                               // move high to mid (left)
           }
        }
        for(int i = low ; i < low + k; i++){                                                            // got the window
            result.add(arr[i]);
        }
        return result;
    }
}