/*
TC: O(n-k) + O(k)

Shrinking the Window:
    The while loop runs O(n−k) times as it reduces the window size from n to k. Each iteration takes
    O(1) time for comparisons and pointer adjustments.

Building the Result List:
    Iterating through k elements to add them to the result list takes O(k).

SC: O(1)
Space used for the output is not counted towards the space complexity.
 */
import java.util.ArrayList;
import java.util.List;

class KClosestElementsTwoPointers
{   //Two Pointers => Linear traversal
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int n = arr.length;
        int low = 0, high = n-1;

        while(high-low+1 > k)
        {
            int distLow = Math.abs(arr[low]-x);
            int distHigh = Math.abs(arr[high]-x);

            if(distLow > distHigh) {
                low++;
            }
            else {
                high--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}