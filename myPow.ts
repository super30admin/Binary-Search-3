// Time Complexity: O(log(n))
// Space Complexity: O(1)
function myPow(x: number, n: number): number {
	let re = 1;
	if (n < 0) {
		x = 1 / x;
		n = -1 * n;
	}
	while (n != 0) {
		if (n % 2 !== 0) re = re * x;
		x = x * x;
		n = Math.floor(n / 2);
	}
	return re;
}
