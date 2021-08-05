# Binary-Search-3

## Problem1

Pow(x,n) (https://leetcode.com/problems/powx-n/)

//Time Complexity = O(logN)
//Space Complexity = O(1)

class Solution {
public double myPow(double x, int n) {
if(n == 0) return 1;
double result = myPow(x,n/2);
if(n % 2 == 0) return result _ result;
else if(n > 0) return result _ result _ x;
else return result _ result \* 1/x;
}
}

## Problem2

Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)

//Time Complexity = O(logN)
//Space Complexity = O(1)

class Solution {
public List<Integer> findClosestElements(int[] arr, int k, int x) {
int low = 0;
int high = arr.length-k;
List<Integer> result = new ArrayList<>();

        while(high > low) {
            int mid = low + (high - low) / 2;
            if(x - arr[mid] > arr[mid+k] - x) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        for(int i = low; i < low + k ; i++) {
            result.add(arr[i]);
        }
        return result;
    }

}
