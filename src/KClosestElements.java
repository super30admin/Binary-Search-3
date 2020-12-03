import java.util.LinkedList;
import java.util.List;

public class KClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new LinkedList<>();
		int low = 0;
		int high = arr.length - k;

		int first = binarySearch(arr, low, high, k, x);
		for (int i = first; i < first + k; i++) {
			result.add(arr[i]);
		}

		return result;

	}

	private int binarySearch(int[] arr, int low, int high, int k, int x) {

		while (low <= high) {
			int first = low + (high - low) / 2;
			int last = first + k - 1;
			if (first > 0 && (x - arr[first - 1] <= arr[last] - x)) {
				high = first - 1;

			} else if (last < arr.length - 1 && (x - arr[first] > arr[last + 1] - x)) {
				low = first + 1;
			} else
				return first;

		}

		return low;

	}

}
