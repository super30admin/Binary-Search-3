package BinarySearch3;

import java.util.ArrayList;
import java.util.List;

public class question88_FindKClosestElements {
    /* Created by palak on 7/7/2021 */

    /*
        TC: O(n)
        SC: O(1)
    */
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length - 1;

        while(high - low + 1 > k) {
            int distL = x - arr[low];
            int distH = arr[high] - x;

            if(distL > distH) {
                low++;
            } else {
                high--;
            }
        }

        for(int i = low ; i < low + k ; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /*
        TC: O(log(n-k))
        SC: O(1)
    */
    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distH = arr[mid + k] - x;

            if(distL > distH) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for(int i = low ; i < low + k ; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    /* Best Asymptotic Solution:
    Binary Search to find the range only.
    We will find the left bound of the range. I am not finding x, nor am I finding the closest element of x. I am trying to find what is the lower/ left bound of the range.
    Low pointer at 0
    High pointer at arr.length - k; It is because the low index cannot be more that arr.length - k as we need to return minimum of k elements and thus the low and high pointer must have the difference of k indices atleast.
    We will not calculate the mid and we will check if mid is the correct point for the left bound of my range that we are finding.
    Therefore, distanceLeftRange = x - arr[mid]; //taking hte first element of the range
    distanceRightRange = arr[mid + k] - x;
    I will take one extra element. There can be a conflict between tho lower bound elements. So therefore I will have to make sure, that the left element taken is the best one.


        TC: O(log(n-k))
        SC: O(1)
    */
    public static List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0) return result;
        int low = 0;
        int high = arr.length - k;

        while(low < high) {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distH = arr[mid + k] - x;

            if(distL > distH) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for(int i = low ; i < low + k ; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        System.out.println(findClosestElements1(arr, k, x));
        System.out.println(findClosestElements2(arr, k, x));
        System.out.println(findClosestElements3(arr, k, x));
    }
}
