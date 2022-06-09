TC - O(log(n-k))
 SC - O(n)
/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findClosestElements = function(arr, k, x) {
    var low = 0,high=arr.length-1;
    while(high-low>=k)
        {
            if(Math.abs(arr[low]-x)>Math.abs(arr[high]-x))
            {
                low++;
            }
            else
            { high--; }
        }
    var ar = [];
    for(let i=low;i<=high;i++)
    {
        ar.push(arr[i]);
    }
    return ar;
};