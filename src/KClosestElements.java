import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(log N or O(K)) which ever is greater.
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Apply binary search to find the mid element which could be x or close to x.
 * Then check both sides of it and append which ever element is closer to it.
 *
 */
class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> ans = new ArrayList<>();
		if (arr.length == k) {
			for (int i = 0; i < k; i++)
				ans.add(arr[i]);
			return ans;
		}
		int index = binarySearch(arr, x);

		int left = index - 1, right = index;

		while (right - left <= k) {
			if (right == arr.length || (left >= 0 && x - arr[left] <= arr[right] - x)) {
				ans.add(0, arr[left--]);
			} else if (left == -1 || (right < arr.length && x - arr[left] > arr[right] - x)) {
				ans.add(arr[right++]);
			}
		}
		return ans;
	}

	public int binarySearch(int[] arr, int x) {
		int left = 0, right = arr.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

}