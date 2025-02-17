import java.util.ArrayList;
import java.util.List;
//658. Find K Closest Elements
// Two pointer based binary search
//Time complexity : O(logn + k)
//Space  Complexity : O(k)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr.length == 0){
            return new ArrayList<> ();
        }
        //binary search
        int left = 0;
        int right = arr.length - 1;
        while(right - left >= k){
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }
        ArrayList<Integer> result = new ArrayList<> ();
        for(int i = left;i<left+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
