# Binary-Search-3
TC: O(log n)
SC: O(1)


## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)

class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }

        double result = myPow(x, n/2);

        //when pow is positive and even
        if(n % 2 == 0){
            result = result * result;
        }

        //when power is odd
        else{
            //when power is positive
            if(n > 0){
                result = result * result * x;
            }

            //when power is negative
            else{
                result = result * result * 1/x;
            }
        }

        return result;
    }

}

## Problem2 
TC: O(log n)
SC: O(1)

Approach:-
1. We use binary search where left = 0 and right is the last index from where we can start picking k elements
2. if the first element of the window A turns out to be greater than the last element of window B then we will move left = mid+1
3. else right = mid

Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)


class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> closestList = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        for (int i = left; i < left + k; i++) {
            closestList.add(arr[i]);
        }
        return closestList;

    }
}
