## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

// Time Complexity - 0(log n) because the input 'n' is divided by 2 at each recursive call. 
//                   This means that the number of recursive calls will be proportional to the logarithm of 'n' 
// Space Complexity - 0(log n)

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double result = myPow(x, n/2);
        if (n % 2 == 0) {
            return result * result;
        }
        else {
            if (n > 0) {
                return result * result * x;
            }
            else {
                return result * result * 1 / x;
            }
        }  
    }
}

## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

// Time Complexity - 0(n) 
// Space Complexity - 0(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = arr.length - 1;
        while (right - left + 1 > k) {
            int distLeft = Math.abs(x - arr[left]);
            int distRight = Math.abs(arr[right] - x);
            if (distLeft > distRight) {
                left++;
            }
            else {
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;      
    }
}