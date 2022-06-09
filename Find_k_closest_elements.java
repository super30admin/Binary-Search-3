import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(log(n-k))
//Space Complexity : O(N)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - k;
        while(low < high){
            int mid  = low + (high - low)/2;
            int dists = x - arr[mid];
            int distl = arr[mid + k] - x;
            if(dists > distl){
                low = mid + 1 ;
            }
            else{
                high = mid;
            }
        }
        for(int i = low ; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}