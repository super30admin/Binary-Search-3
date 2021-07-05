// ## Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// time: O(logN)
// spac: O(logN)

const myPow = function(x, n) {
    // base
    if(n === 0) return 1; 
    // logic
    let temp = myPow(x, parseInt(n/2));
    if(n % 2 === 0) return temp * temp;
    else {
        if(n < 0) return temp * temp * (1/x);
        else return temp * temp * x;
    }
}