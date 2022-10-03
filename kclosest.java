Time Complexity: O(N)
Space Complexity: O(1)
public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int l = 0, r = arr.length - 1;
		while (r - l >= k) {
			if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r]))
				r--;
			else
				l++;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = l; i <= r; i++, l++)
			result.add(arr[l]);
		return result;
	}