import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Aditya Sinha
 * binary search the best starting index for the k closest elements
 * each step compare the distance between start and end of the current window
 * Once found, take the k elements starting from that index
 * Time Complexity - O(log(n - k)) + O(k)
 * Space Complexity - O(1)
 *
 */
public class KClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;

        int low = 0, high = n - k;

        while(low < high){
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i< low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}
