//Two pointer
//TC:  O(n)
//SC: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;

        while (high - low + 1 > k) {
            int distL = x - arr[low]; // distance of low from x
            int distH = arr[high] - x; // distance of x from high

            if (distL > distH) {
                low++; // if low distance is greater than move low pointer else move high pointer
            } else {
                high--; // this will check for the equal differences as well i.e if distL == distH then
                        // distL should be considered
            }
        }

        List<Integer> result = new ArrayList<>(); // store k elements in arraylist
        for (int i = low; i <= high; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

// Binary search
// TC: O(log(n-k))+O(k)  -> log(n-k) for finding the range and o(k) for adding it to result list
// SC: O(1)

// we are finding potential starting point here and after finding that we can
// have the range of elements .
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; // potential starting point can be either at 0 or n-k
        int high = arr.length - k;

        while (low < high) {

            int mid = low + (high - low) / 2;
            int distL = x - arr[mid]; // distance of x from mid
            int distH = arr[mid + k] - x; // distance of arr[mid+k] from x because if mid is the potential starting
                                          // starting point then the range will be from mid to mid+k -1 . We are taking
                                          // one element extra here i.e. instead of mid+k-1 we are taking mid+k so as to
                                          // check for the conditions where the distance at low and mid+k is equal

            if (distL > distH) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>(); // store k elements in arraylist
        for (int i = low; i < low + k; i++) {  
            result.add(arr[i]);
        }
        return result;
    }
}
