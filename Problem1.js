// ## Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)


var myPow = function(x, n) {
    //! Square the Base and Half the exponent
    //TC : O(Log n)
    //SC : O(1)
    function helper(x,n){
    if(x == 0){
        return 0
    }
    if(n == 0){
        return 1
    }
    let res = helper(x*x,Math.floor(n/2))
    return n%2 == 0 ? res : x*res
    }
    let res = helper(x,Math.abs(n))
    return n >= 0 ? res : 1/res 
};

// var myPow = function(x, n) {
//     //TC: O(n)
//     //SC : O(1)
//     let res = 1
//     for(let i =0;i<Math.abs(n);i++){
//         res *= x
//     }  
//     if(n < 0){
//         //if n is negative return the 1/res of the result
//         return 1/res 
//     }
//     return res
// };