# Heap-1
Problem1
https://leetcode.com/problems/powx-n/solution/
// Time Complexity : O(nlong)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// method: recusily calls: eg: for 2^6.. find 2^3X2^3

class Solution {
    public double myPow(double x, int n) {
        double prod=1;
        //base:
        if(n==0) return 1;
        
        //logic:
        double p=myPow(x,n/2);
        if(n%2==0){
            return p*p;
        }
        else{
            if(n<0){
                return p*p*1/x;
            }
            else{
                return p*p*x;
            }
        }
}
}



Problem2
https://leetcode.com/problems/find-k-closest-elements/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
method #1: 2 pointer approach - Keep squeezing the pointers unless the diff = k. If diff(value and arr[index])>x then increment low else descrement high
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr==null || arr.length==0) return result;
        int low=0; int high=arr.length-1;
        while(high-low+1>k){
            if(Math.abs(x-arr[low]) > Math.abs(x-arr[high])){
                low++;
            }
            else {
                high--;
            }
        }
        for(int i=low;i<=high;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
