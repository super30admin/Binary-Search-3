
//Time Complexity : O(N - K)
//Space Complexity: O(1)
import java.util.*;

class Solution1 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<>();
		if (arr == null || arr.length == 0)
			return list;
		int low = 0;
		int high = arr.length - 1;
		while (high - low > k - 1) {
			int distL = Math.abs(x - arr[low]);
			int distR = Math.abs(x - arr[high]);
			if (distL > distR)
				low++;
			else {
				high--;
			}
		}
		for (int i = low; i < low + k; i++) {
			list.add(arr[i]);
		}
		return list;
	}
}