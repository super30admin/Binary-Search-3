import java.util.ArrayList;
import java.util.List;

//Binary Search solution
//Time Complexity : O(k) (for populating the result list) + O(log(n-k)) where n is the length of the arr array
// Space Complexity : O(1) no auxiliary space is used
// Did this code successfully run on Leetcode :yes

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length < 1){
            return result;
        }

        int n = arr.length;
        int low = 0;
        int high = n-k;
        int mid =  low + (high-low)/2;

        while(low < high){//O(log(n-k))
            mid = low + (high-low)/2;
            int lowDiff = x - arr[mid];
            int highDiff = arr[mid+k] - x;
            if(lowDiff > highDiff){
                low = mid +1;
            }else{
                high = mid;
            }
        }

        for(int i = low; i<low+k; i++){ //O(k)
            result.add(arr[i]);
        }
        return result;
    }

    //Two-pointer solution
    //Time Complexity : O(n) where n is the length of the arr array
    // Space Complexity : O(1) no auxiliary space is used
    // Did this code successfully run on Leetcode :yes
    public List<Integer> findClosestElementsLinear(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length < 1){
            return result;
        }
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(high - low + 1 > k){
            int lowDiff = Math.abs(x-arr[low]);
            int highDiff = Math.abs(x-arr[high]);

            if(lowDiff > highDiff){
                low++;
            }else{
                high--;
            }
        }
        for(int i = low; i<=high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
