// Time Complexity : O(n-k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes
// Approach 1: we take low and high pointer starting at 0 and length -1
//We move inwards till 2 pointers have a distance > k value
//Find the absolute dist at the low and high pointer values
//move the pointer whose abs dist is greater 
//iterate over the arr starting from low till the high pointer and push the values and return the result

// Time Complexity : O(log(n-k)) + O(k)
// Space Complexity : O(k))
// Did this code successfully run on Leetcode : Yes
// Approach 2: we start with two pointers one fron 0 and second from length - k
//Find the dist of the start which isd the elem at mid - x value and end at mid + k elem
//move the pointer whose abs dist is greater 
//iterate over the arr starting from low till the high pointer and push the values and return the result


//Approach 1
var findClosestElements = function (arr, k, x) {
    let result = [];
    if (!arr || arr.length === 0) return result;
    let low = 0;
    let high = arr.length - 1;
    while (high - low + 1 > k) {
        let distL = Math.abs(arr[low] - x);
        let distH = Math.abs(arr[high] - x);
        if (distL > distH) {
            low++;
        } else {
            high--;
        }
    }
    for (let i = low; i <= high; i++) {
        result.push(arr[i]);
    }

    return result;
};



//Approach 2
var findClosestElements = function (arr, k, x) {
    let result = [];
    if (!arr || arr.length === 0) return result;
    let low = 0;
    let high = arr.length - k;
    while (low < high) {
        let mid = Math.floor((low + high) / 2);
        distS = x - arr[mid];
        distE = arr[mid + k] - x;
        if (distS > distE) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }
    for (let i = low; i < low + k; i++) {
        result.push(arr[i]);
    }
    return result;
};