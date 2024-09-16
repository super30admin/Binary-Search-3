import java.util.ArrayList;
import java.util.Collections;
// Bruteforce
// TC - O(n+klogk)
// SC - O(1)

import java.util.List;

class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int i;
        int j=0;
        for(i=0;i<arr.length;i++) {
            if(arr[i] == x) {
                result.add(arr[i]);
                j = i+1;
                break;
            } else if(arr[i] > x) {
                j = i;
                break;
            }
        }

        if (i == arr.length) {
            j = arr.length; 
        }
        int a = i-1;
        int b = j;
        while(b-a != k+1) {
            if (a >= 0 && (b >= arr.length || Math.abs(arr[a] - x) <= Math.abs(arr[b] - x))) {
                result.add(arr[a]);  // Add the closer left element
                a--;
            } else if (b < arr.length) {
                result.add(arr[b]);  // Add the closer right element
                b++;
            }
        }
        Collections.sort(result);  
        return result;
    }
}



// Two-pointer technique
// TC - O(n)
// SC - O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int low = 0;
        int high = arr.length-1;
        if(x > arr[high]) {
            for(int i=n-k;i<n;i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if(x < arr[low]) {
            for(int i=0;i<k;i++) {
                result.add(arr[i]);
            }
            return result;
        }
        while(high-low >= k) {
            int eleLow = arr[low];
            int eleHigh = arr[high];
            if(Math.abs(eleLow-x) <= Math.abs(eleHigh-x)) {
                high--;
            } else{
                low++;
            }
        }
        System.out.println(low);
        System.out.println(high);
        for(int i = low;i<=high;i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

//Binary search technique to find the start of the window 
// TC - O(log n)
// SC - O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int low = 0;
        int high = n-k;
        while(low < high) {
            int mid = low + (high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            if(distS <= distE) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        for(int i=low;i<low+k;i++) {
            result.add(arr[i]);
        }
        return result;
    }
}