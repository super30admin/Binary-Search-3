// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// 2 pointers
// Time Complexity : O(n-k)
// Space Complexity : O(1)

// Binary search
// Time Complexity : O(log(n-k))
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function (arr, k, x) {

    if (arr === null || arr.length === 0 || k === 0)
        return [];

    // 2 Pointers
    //     let n = arr.length;
    //     let low = 0;
    //     let high = n-1;

    //     while( (high - low + 1) > k) {
    //         let diststart = x - arr[low];
    //         let distend = arr[high] - x;
    //         if(diststart <= distend){
    //             high--;
    //         } else {
    //             low++;
    //         }
    //     }
    //     return arr.slice(low, low + k);

    // Binary Serach
    let n = arr.length;
    let low = 0;
    let high = n - k;
    while (low < high) {
        let mid = Math.floor(low + ((high - low)) / 2);
        let distS = x - arr[mid];
        let distE = arr[mid + k] - x;
        if (distE < distS) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    return arr.slice(low, low + k);
};