import java.util.ArrayList;
import java.util.List;

//Time complexity is O(logn)
//Space complexity is O(1)
//This solution is submitted on leetcode

public class BigN86KthClosestElementUsingBinarySearch {
	class Solution {
		public List<Integer> findClosestElements(int[] arr, int k, int x) {
			List<Integer> result = new ArrayList<>();
			// edge case
			if (arr == null || arr.length == 0)
				return result;
			int low = 0;
			int high = arr.length - k;
			while (low < high) { 
				int mid = low + (high - low) / 2;
				int disL = Math.abs(x - arr[mid]);
				int disR = Math.abs(x - arr[mid + k]);
				if (disL > disR) {
					low = mid + 1;
				} else
					high--;
			}
			for (int i = low; i < low + k; i++) {
				result.add(arr[i]);
			}
			return result;
		}
	}
}