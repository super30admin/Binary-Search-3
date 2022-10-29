// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity : O(logn)
// Space Complexity : O(logn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function (x, n) {
    //     // Recursive
    //     // Base
    //     if(n === 0)
    //         return 1;

    //     // Logic
    //     let result = myPow(x, parseInt(n/2));
    //     if(n % 2 === 0){
    //         // Even Power
    //         return result * result;
    //     } else {
    //         // Odd Power
    //         if(n>0){
    //             // Positive
    //             return result * result * x;
    //         } else {
    //             // Negative
    //             return result * result * (1/x);
    //         }
    //     }

    // Iterative
    let N = n;
    if (N < 0) {
        x = 1 / x;
        N = -N;
    }
    let ans = 1;
    let curr_prod = x;
    for (let i = N; i > 0; i = parseInt(i / 2)) {
        if (i % 2 !== 0) {
            // It is an odd number
            ans = ans * curr_prod;
        }
        curr_prod = curr_prod * curr_prod;
        console.log(ans)
    }
    return ans;
};