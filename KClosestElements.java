//In this approach, we try to find the starting index of the range using binary search.
//We take the distance of start and end elements of the range from the given value and see if they are equidistant from the value
//If the starting distance is more, then we move low to right else, we move high to left
//Time Complexity: O(log(n-k)) where n is the length of the array
//Space Complexity: O(1)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low  = 0;
        int high = n-k;
        while(low < high){
            int mid = low + (high -low) / 2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}