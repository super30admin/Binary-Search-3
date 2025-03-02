/*
 * Time Complexity: O(log n + k)
 * Space Complexity: O(1)
 */
import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // get the index of the element closest to x in magnitude
        int closestIndex = findClosestIndex(arr, x);

        // expand from this index on either side
        // until the size of the window is k
        int l = closestIndex - 1;
        int r = closestIndex;
        while(r - l - 1 < k) {
            if(l >= 0 && r < arr.length) {
                if(x - arr[l] <= arr[r] - x) {
                    l--;
                }
                else {
                    r++;
                }
            } else if (l >= 0) {
                l--;
            } else if (r < arr.length) {
                r++;
            } else {
                break;
            }
        }

        // fill the result list with elements from the window
        List<Integer> closestElements = new ArrayList<>();
        for(int i = l + 1; i < r; i++) {
            closestElements.add(arr[i]);
        }
        return closestElements;
    }
    /**
     * Finds the closest index to @param x in
     * @param arr using binary search
     *
     * @return first index of element closest to x
     */
    int findClosestIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(Math.abs(arr[mid] - x) <= Math.abs(arr[res] - x)) {
                res = mid;
            }
            if(arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
