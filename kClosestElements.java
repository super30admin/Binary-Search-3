package BinarySearch3;
// Time Complexity : O(log(n) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.List;

public class kClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        int low = 0;
        int high = arr.length;
        while (low < high){
            int mid = low + (high-low) / 2;
            if(arr[mid] < x){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        low = low - 1;
        high = low + 1;
        while ( high - low - 1  < k){
            if(low >=0 && high < arr.length)
            {
                if((x - arr[low]) <= (arr[high] - x))
                    low--;
                else
                    high++;
            }
            else if(low >=0)
                low--;
            else
                high++;
        }
        for (int i = low + 1; i < high; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
