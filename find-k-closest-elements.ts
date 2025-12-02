// First, we perform a binary search on the index range 0 to (n - k) to find the optimal starting index
// for the k closest elements.
// Since we must find k contiguous elements, the last possible starting index is n - k.
// Once the optimal starting index is found, we take the k elements from that position
// in the already sorted array to form the result.
// Time Complexity: O(log(n-k)) + O(k)
// Space Complexity: O(1)
function findClosestElements(arr: number[], k: number, x: number): number[] {
	let n = arr.length;
	let low = 0;
	let high = n - k;

	while (low < high) {
		let mid = Math.floor((low + high) / 2);

		const distl = x - arr[mid];
		const distH = arr[mid + k] - x;

		if (distl <= distH) {
			high = mid;
		} else {
			low = mid + 1;
		}
	}

	const result = [];
	for (let i = low; i < low + k; i++) {
		result.push(arr[i]);
	}
	return result;
}
