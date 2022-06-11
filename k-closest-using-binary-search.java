import java.util.*;

class Solution {
    // Binary Search  solution
    // Time complexity is O(log(n-k))
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length -k;
        while(low<high){
            // Since we are calculating range, will use low<high and high = mid here 
            int mid = low +  (high-low)/2;
            int distL = x- arr[mid];
            int distH = arr[mid+k] -x; // taking one extra element
            if(distL>distH){
                low = mid+1;
            } else{
                high = mid;
            }
        }
        for (int i = low; i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}