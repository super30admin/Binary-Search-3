//https://leetcode.com/problems/powx-n/
//// Time Complexity : O(lg n) where n is the power being raised
//// Space Complexity : O(lg n) stack space
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// In javascript Math.floor of negative numbers is different.
// Math.floor(1/2) => 0, but Math.floor(-1/2) => -1
// Had to play a lot with Math.abs and Math.sign so that
// Math.floor(-x) == -1 * Math.floor(x) by doing Math.sign(x) * Math.floor(Math.abs(x)/y)

//// Your code here along with comments explaining your approach

// Recursively divide the power by 2 via integer division til you reach...
// ...base case: power = 0, return 1

// if pow is an even number
//    return currval * currval
// else
//    if pow is positive
//      return currval * currval * x
//    else
//      return currval * currval * 1/x
var myPow;

myPow = function(x, n) {
  var recurVal;
  if (n === 0) {
    return 1;
  }
  recurVal = myPow(x, Math.sign(n) * (Math.floor(Math.abs(n) / 2)));
  if (n % 2 === 0) {
    return recurVal * recurVal;
  } else {
    if (n < 0) {
      return recurVal * recurVal * 1 / x;
    } else {
      return recurVal * recurVal * x;
    }
  }
};

myPow(2, 10);

myPow(2, -2);

//# sourceMappingURL=problem1-pow.js.map
