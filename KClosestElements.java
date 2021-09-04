//https://leetcode.com/problems/find-k-closest-elements/
/*
Time: O(log(n-k)) + O(k)
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class KClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();

        int n = arr.length;
        int left = 0; // leftMinIndex
        int right = n - k; // leftMaxIndex
        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((x - arr[mid]) > (arr[mid + k] - x)) // right side is smaller, go right
                left = mid + 1; // left is after mid

            else
                right = mid; // left is either at mid or before mid, no use for elements after 'mid+k'

        }

        for (int i = left; i < left + k; i++)
            result.add(arr[i]);

        return result;

    }

}
