// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k <= 0) return Collections.emptyList();

	int n = arr.length;
	
	int start = 0, end = n - k - 1;
	while (start <= end) {
		int mid = start + (end - start) / 2;

		if (x - arr[mid] > arr[mid + k] - x) 
			start = mid + 1;
		else
			end = mid - 1;
	}
	List<Integer> result = new ArrayList<>();
	for (int i = start; i < start + k; i++) result.add(arr[i]);
	return result;
    }
}