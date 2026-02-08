/**
 *
 * Intuition :
 * - If n is negative, invert x and use -n instead.
 * - Instead of multiplying x by itself n times, we build the result using powers of two.
 *   - currProduct stores the current power of x (x, x^2, x^4, ...).
 *   - For each bit in the binary representation of n:
 *       - If the bit is 1 (i % 2 === 1), multiply ans by currProduct.
 *       - Square currProduct for the next bit.
 * - This reduces the number of multiplications from O(n) to O(log n).
 */
var myPow = function (x, n) {
    if (n < 0) {
        x = 1 / x;
        n = -n;
    }

    let ans = 1, currProduct = x;
    for (let i = n; i > 0; i = Math.floor(i / 2)) {
        if (i % 2 === 1) {
            ans = ans * currProduct;
        }
        currProduct *= currProduct;
    }
    return ans;
};
