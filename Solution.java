//Here we are found the window of (right-left+1 > k) then get the distance from left and righ direction. 
//then iterate over left to right and return.

import java.util.*;

class FindKClosestElements {
    // TC: O(logn+k) SC: O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return result;
        }
        int n = arr.length;
        int low = 0;
        int high = n - k;
        int mid = low + (high - low) / 2;

        while (low < high) {// O(log(n-k))
            mid = low + (high - low) / 2;
            int lowDiff = x - arr[mid];
            int highDiff = arr[mid + k] - x;
            if (lowDiff > highDiff) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i = low; i < low + k; i++) { // O(k)
            result.add(arr[i]);
        }
        return result;
    }

    // Two-pointer solution with linear time
    // TC: O(n) SC: O(k)
    public List<Integer> findClosestElementsLinearTime(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length < 1) {
            return result;
        }
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (high - low + 1 > k) {
            int lowDiff = Math.abs(x - arr[low]);
            int highDiff = Math.abs(x - arr[high]);

            if (lowDiff > highDiff) {
                low++;
            } else {
                high--;
            }
        }
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}

// TC: O(log n) SC: O(logn)
public class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            return power(x, n);
        } else
            return 1L / power(x, -1 * n);
    }

    private double power(double x, int n) {
        if (n == 0) {
            return 1L;
        }

        double halfPower = power(x, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        }

        return x * halfPower * halfPower;
    }
}
