import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low =0;
        int high = arr.length-k; //last strting point of range
        while(low < high)
        {
            int mid = low + (high-low)/2;
            int distS = x-arr[mid];
            int distE = arr[mid+k] -x;
            if(distS > distE)
            {
                low = mid+1;
            }
            else
            {
                //equal
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i< low+k; i++)
        {
            result.add(arr[i]);
        }
        Collections.sort(result);
        return result;
    }
}
