// Time Complexity : O(logn + k)
// Space Complexity : O(1) or O(k) depending on if you consider the output array as space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function(arr, k, x) {
    // Base cases
    if (!arr || !arr.length) return [];
    if (x < arr[0]) return arr.slice(0, k);
    if (x > arr[arr.length - 1]) return arr.slice(arr.length - k, arr.length);
    
    let left = 0,
        right = arr.length - 1,
        mid;

    // Do a binary search for x over the WHOLE array
    while (left <= right) {
        mid = Math.floor((left + right) / 2);
        if (arr[mid] == x) break;
        else if (arr[mid] > x) right = mid - 1;
        else left = mid + 1;
    }
    
    // NOW set my window once I'm as close as possible to X
    left = Math.max(0, mid - k - 1);
    right = Math.min(arr.length - 1, mid + k - 1);

    // This while loop walks my left and right pointers away
    // from the found mid step by step, ensuring that they
    // don't go over the bounds of the array
    while (right - left > k - 1) {
        if (left < 0 || x - arr[left] <= arr[right] - x) right--;
        else if (right > arr.length - 1 || x - arr[left] > arr[right] - x) left++;
    }
    
    // Now just return a subarray from left to right
    return arr.slice(left, right + 1);
};
