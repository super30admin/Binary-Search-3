// # Binary-Search-3

// ## Problem1 
// Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity : O(log n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        double re = myPow(x, n/2);
        if(n%2 == 0){
            return re*re;
        }else{
            if(n>0){
                return re*re*x;
            }else{
                return re*re*(1/x);
            }
        }
    }
}


// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE){
            x = x*x;
            n = n/2;
        }
        if(n<0){
            x = 1/x;
            n = n*(-1);
        }
        double result = 1.0;
        while(n>0){
            if(n%2 != 0){
                result = result * x;
            }
            x = x * x;
            n = n/2;
        }
        return result;
    }
}



// ## Problem2 
// Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Complexity : O(log n-k)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I didnt face any problem while coding this.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0; int high = arr.length - k;
        while(low < high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;
            if(distS > distE){
                low = mid+1;
            }else{
                high = mid;
            }
            }
            List<Integer> result = new ArrayList<>();
            for(int j=low; j<low+k; j++){
                result.add(arr[j]);
            }
        return result;
    }
}