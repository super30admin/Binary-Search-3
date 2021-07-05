// Time Complexity : O(logn)
// Space Complexity : O(logn) recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public double myPow(double x, int n) {

        // base case
        if (n == 0) // when power becomes zero
            return 1;

        double temp = myPow(x, n / 2); // call recursively on n/2 power and store in temp each time

        // when recursion unfolds
        if (n % 2 == 0) // if power is even
            return temp * temp; // multiply temp by itself
        else { // if power is odd
            if (n > 0) // power is positive
                return temp * temp * x; // consider x also
            else // power is negative
                return temp * temp * (1 / x); // consider 1/x
        }

    }
}

// Time Complexity : O(n-k) + O(k) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; // left pointer
        int high = arr.length - 1; // right pointer
        List<Integer> result = new ArrayList<>();

        while (high - low != k - 1) { // till the window between the pointers is k-1
            int distL = Math.abs(x - arr[low]); // find absolute distance of x from the number at low
            int distH = Math.abs(x - arr[high]); // find absolute distance of x from the number at high
            if (distL > distH) // if distance at low is higher
                low = low + 1; // we need to go to smaller distances so move low pointer
            else
                high = high - 1; // else move high

        }

        for (int i = low; i < low + k; i++) { // go from low to k elements and add to result
            result.add(arr[i]);
        }

        return result;
    }
}

// Time Complexity : O(n-k) + O(k) = O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k; // set so that we can move to get k elements
        List<Integer> result = new ArrayList<>();

        while (low < high) { // binary search
            int mid = low + (high - low) / 2; // find mid
            int distL = Math.abs(x - arr[mid]); // find distance of window starting at mid
            int distH = Math.abs(x - arr[mid + k]); // find distance of window ending at mid+k
            if (arr[mid] == arr[mid + k]) { // if duplicates exist
                if (x > arr[mid]) // check if value to be found is greater than that at mid....we have to find the
                                  // value from where it doesnt repeat
                    low = mid + 1; // move low
                else
                    high = mid; // else move high
            } else {
                if (distL > distH) // if distance of start of window is high
                    low = mid + 1; // move low
                else
                    high = mid; // move high
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}