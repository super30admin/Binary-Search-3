///**
// * @param {number} x
// * @param {number} n
// * @return {number}
// */
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
