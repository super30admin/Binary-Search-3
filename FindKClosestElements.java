import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElementsTwoPointers(int[] arr, int k, int x) {
        //overall T.C, O(n-k) + O(k) = O(n-k). overall S.C, O(1)
        int start = 0; //start pointer
        int end = arr.length - 1; //end pointer

        while((end-start+1) > k) { //while both pointers are at a distance of at least k apart, O(n-k) T.C
            int startDiff = Math.abs(arr[start] - x); //find the absolute distance of a start pointer with given x
            int endDiff = Math.abs(arr[end] - x); //and of end pointer with given x

            if(startDiff > endDiff) start++; //if the start difference is more, increment start
            else end--; //similarly, if the end is less or equal, decrement end
            // (this makes sure we always take smaller value in case of equidistant differences.)
        }

        List<Integer> result = new ArrayList<>();
        for(int i=start; i<=end; i++) { //sliding window
            result.add(arr[i]); //O(k) T.C
        }

        return result;
    }

    /*
    Intuition behind this modified binary search is to find the correct start point of the range.
    At each mid, find the distance of it from starting value and its potential ending value and move
    the mid until the starting distance is either equal or greater than that of ending distance.
     */
    public static List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        //overall T.C, O(log(n-k)) + O(k) = O(log(n-k)). overall S.C, O(1).
        int low = 0;
        int high = arr.length - k; //the starting range index can only be until length - k places of input

        while(low < high) { //O(log(n-k)) T.C
            int mid = low + (high - low) / 2;

            if(x - arr[mid] > arr[mid+k] - x) //we take one extra index at high to always reject the actual end
                // if it is equidistant with start i.e., we take mid+k instead of mid+k-1.
                low = mid+1; //if the start diff is high, move low
            else high = mid; //else, move high
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k; i++) { //sliding window
            result.add(arr[i]); //O(k) T.C
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,9};

        int k1 = 3;
        int x1 = 2;

        System.out.println(k1 + " closest elements to value " + x1 + " in the array " + Arrays.toString(arr)
                + " using two pointers is: " + findClosestElementsTwoPointers(arr, k1, x1));

        int k2 = 4;
        int x2 = 5;

        System.out.println(k2 + " closest elements to value " + x2 + " in the array " + Arrays.toString(arr)
                + " using binary search is: " + findClosestElementsBinarySearch(arr, k2, x2));
    }
}