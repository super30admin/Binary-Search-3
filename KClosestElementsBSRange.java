/*
Given N as the length of arr,
Time complexity: O(log(N−k)+k).

Although finding the bounds only takes O(log(N−k)) time from the binary search, it still costs us O(k)
to build the final output.

Space complexity: O(1).

Again, we use a constant amount of space for our pointers, and space used for the output does not count
towards the space complexity.
 */
import java.util.ArrayList;
import java.util.List;

class KClosestElementsBSRange
{   //Optimal Solution => binary search to find the range
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int n = arr.length;
        int low = 0, high = n-k;

        while(low < high)
        {
            int mid = low + (high-low)/2;

            /*
            Here we cannot use the absolute distance because we if the distStart and distEnd become same,
            we will not know which direction to move
             */
            int distStart = x - arr[mid];
            int distEnd = arr[mid+k] - x;

            if(distStart > distEnd) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}