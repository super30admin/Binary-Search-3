//Time: O(Logn + m) // logn for binary search and m for k elements(K is given in the fuxnion)
//spcae: O(n) // n- o/p list
import java.util.ArrayList;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        
        int start = 0;
        int end = arr.length - k;
        
        while(start < end){
            int mid = (start + end)/ 2;
            // this is done to check which side is closer to target, left or right.
            if(x - arr[mid] > arr[mid+k]-x){
                start = mid + 1;
            }else {
                end = mid;
            }
        }
        // System.out.println("start" + start);
        // to add the sublist after finding the start point of the k closest elems
        for(int i = start; i < start + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}