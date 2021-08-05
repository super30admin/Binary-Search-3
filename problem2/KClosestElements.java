// Time Complexity : O(log (n - k) + k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
	/******************************* TWO POINTERS *******************************/
	// Time Complexity : O(n)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public List<Integer> findClosestElementsTwoPointers(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return result;
		}

		int left = 0;
		int right = arr.length - 1;

		while (right - left + 1 > k) {
			int distLeft = x - arr[left];
			int distRight = arr[right] - x;
			if (distLeft > distRight) {
				left++;
			} else {
				right--;
			}
		}

		for (int i = left; i < left + k; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	/************************** CLOSED BINARY SEARCH **************************/
	// Time Complexity : O(log (n - k) + k)
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return result;
		}

		int left = 0;
		int right = arr.length - k;

		while (left < right) {
			int mid = left + (right - left) / 2;
			int distLeft = x - arr[mid];
			int distRight = arr[mid + k] - x;
			if (distLeft > distRight) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		for (int i = left; i < left + k; i++) {
			result.add(arr[i]);
		}
		return result;
	}

	public void print(List<Integer> arr) {
		for (Integer num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		KClosestElements obj = new KClosestElements();
		int[] nums = { -1, 2, 3, 7, 9, 13, 15, 16 };
		int k = 3;
		int x = 11;
		System.out.println("k closest elements to " + x + ": ");
		obj.print(obj.findClosestElements(nums, k, x));
	}

}
