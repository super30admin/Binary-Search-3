
// ## Problem2 
// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)
var findClosestElements = function(arr, k, x) {
    //TC : O(Log n-k)
    //SC : O(1)
    let left = 0;
    let right = arr.length - k;
    
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (x - arr[mid] > arr[mid + k] - x) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return arr.slice(left, left + k);
};

// var findClosestElements = function(arr, k, x) {
//     //TC : O(N)
//     //SC : O(1)
//     let left = 0
//     let right = arr.length-1
//     let ans = []
//     while(((right-left)+1) > k){
//         let leftDiv = Math.abs((arr[left]-x))
//         let rightDiv = Math.abs((arr[right]-x))
//         if(leftDiv <= rightDiv){
//             right--
//         }
//         else{
//             left++
//         }
//     }
//     //got the window 
//     // now put the ele in ans
//     for(let i = left; i<= right;i++){
//         ans.push(arr[i])
//     }
//     return ans
// };

// console.log(findClosestElements([1,2,3,3,5,6,7],3,4))