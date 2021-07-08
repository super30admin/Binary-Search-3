// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    if (x == 0) return n >= 0 ? 0 : Infinity;
    if (n == 0 || x == 1) return 1;
    if (x == -1) return n % 2 == 0 ? 1 : -1;

    if (n < 0) {
        x = 1/x;
        n = -n;
    }
    let result = 1,
        currProduct = x;
    for (let i = n; i > 0; i = Math.floor(i / 2)) {
        if ((i % 2) == 1) result *= currProduct;
        currProduct *= currProduct;
    }
    return result;
};
