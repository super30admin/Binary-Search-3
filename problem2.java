class Solution {
    //max-heap
    //binary search
    //2-pointer
    //range binary search
    //time- O(log (n - k) + k)
    //space-O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
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
}