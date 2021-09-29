// Time Complexity : O(log(n))
// Space Complexity : O(log(n))
// Did this code successfully run on Leetcode : Yes
// Approach : We recursively call the myPow function by dividing the power by 2 till power becomes 0
// if the pwer is even then we multiply the result by itself
// if odd we check positive or negative, in positive we even multiply the x and negative 1/x

var myPow = function (x, n) {
    if (n === 0) return 1.00;
    let result = myPow(x, parseInt(n / 2));
    if (n % 2 === 0) return result * result;
    else {
        if (n < 0) return result * result * (1 / x);
        else return result * result * x;
    }
};