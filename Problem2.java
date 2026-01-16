//TC = O(log(n-k) + k)
//SC = O(1)

/*
Initialize low = 0 and high = n-k, we want to find the starting range of the result.
Once we calculate the mid, calculate the difference between x and mid and mid+k and x
if distL > distR move low = mid + 1, which means that there is a possibility that the range might start after mid.
Else move high = mid
*/

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low  = 0;
        int high = n - k;

        while(low < high) {
            int mid = low + (high-low)/2;
            int distL = x - arr[mid];
            int distR = arr[mid+k] - x;

            if(distL > distR) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i = low;i<=low+k-1;i++) {
            res.add(arr[i]);
        }

        return res;
        
    }
}
