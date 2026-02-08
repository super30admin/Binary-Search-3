/**
 * Use binary search to find the left boundary of the window of size k closest to x.
 * Compare distances from x at the ends of the window to decide which side to move.
 * Once the boundary is found, slice k elements starting from it for the result.
 T.C: O(log(n-k)) 
 S.C: O(1)
 */

var findClosestElements = function (arr, k, x) {
    const res = [];
    // Binary Search
    let low = 0, high = arr.length - k;
    while (low < high) {
        const mid = low + Math.floor((high - low) / 2);
        distFromS = x - arr[mid];
        distanceFromE = arr[mid + k] - x;
        if (distFromS > distanceFromE) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    for (let i = low; i < low + k; i++) {
        res.push(arr[i]);
    }
    return res;
};