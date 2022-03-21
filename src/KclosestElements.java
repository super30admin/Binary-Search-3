// Time Complexity:    O(log(n-k))
// Space Complexity:   O(log(1))
// where n is number of elements in array
// This code ran successfully on Leetcode

import java.util.ArrayList;
import java.util.List;

public class KclosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int l = 0, r = arr.length-k;

        while(l < r) {
            int mid = l + (r-l)/2;

            int d1 = Math.abs(x - arr[mid]);          // distance of "x" from first element of window
            int d2 = Math.abs(x - arr[mid+k]);        // distance of "x" from very next of last element of window

            if(arr[mid] == arr[mid+k]) {              // all elements in window are same
                if(arr[mid] < x) {                    // and "x" is greater than element
                    l = mid+1;                        // move to right direction
                }
                else {                                // else
                    r = mid;                          // move to left direction
                }
            }
            else if(d1 > d2) {                        // if all elements are not same in window and "x" is near to end of window
                l = mid+1;                            // then move to right direction
            }
            else {                                    // else
                r = mid;                              // move to left direction
            }
        }

        List<Integer> result = new ArrayList<>();     // mid is set to start of result window
        for(int i=l; i<l+k; i++) {                    // simply take all elements
            result.add(arr[i]);
        }
        return result;
    }
}