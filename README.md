# Binary-Search-3

## Problem1 
Pow(x,n) (https://leetcode.com/problems/powx-n/)


Approached Solution: This solution calculated x^n efficiently using an iterative approach based on exponentiation by squaring. If n is negative x is inverted and n is made positive. The algorithm iterates while n is non-zero, if n is odd, x is multiplied into the result and in each iteration x is squared and n is halved. This method reduces the number of multiplications, achieving a logarithmic time complexity, as each step essentially halves n until it reaches zero.

Time Complexity: O(log n) as the exponent n is halved in each iteration.

Space Complexity: O(1) as we are not using any auxillary space.

Approached Code:

class Solution {
    public double myPow(double x, int n) {

        // if(n == 0) {
        //     return 1.0;
        // }

        // double result = myPow(x, n/2);

        // if(n%2 == 0) {
        //     return result * result;
        // } else {
        //     if(n < 0) {
        //         return result * result * 1/x;
        //     } else {
        //         return result * result * x;
        //     }
        // }



        double result = 1.0;

        if(n < 0) {
            x = 1/x;
            n = n * -1;
        }

        while(n != 0) {
            if(n%2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n/2;
        }

        return result;

    }
}



## Problem2 
Find K Closest Elements (https://leetcode.com/problems/find-k-closest-elements/)


Approached Solution: This solution finds the k closest elements to x in a sorted array using a binary search approach. Since the array is sorted we can leverage binary search to quickly identify the starting index of the k closest elements. The search space is set between indices 0 and n - k ensuring the selected subarray contains exactly k elements. In each iteration it calculates distances from x for the midpoint and the element at mid + k and adjusts the bounds to move towards the closer elements. Finally the result is gathered by iterating from the found starting index for k elements which are already sorted due to the input array's order.

Time Complexity: O(log(n−k)+k) as the binary search takes O(log(n−k)) and collecting k elements takes O(k).

Space Complexity: O(k) as required to store the result list of k elements.

Approached Code:

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        // Heap Solution

        // PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> {
        //     if(a[1] == b[1]) {
        //         return b[0] - a[0];
        //     }
        //     return b[1] - a[1];
        // });

        // for(int i = 0; i < arr.length; i++) {
        //     int dist = Math.abs(arr[i] - x);
        //     pq.add(new int[] {arr[i], dist});

        //     if(pq.size() > k) {
        //         pq.poll();
        //     }
        // }

        // List<Integer> result = new ArrayList<>();

        // while(!pq.isEmpty()) {
        //     int[] polled = pq.poll();
        //     result.add(polled[0]);
        // }

        // Collections.sort(result);

        // return result;



        // Two Pointers Solution

        // int n = arr.length;
        // int low = 0;
        // int high = n - 1;

        // while(high - low + 1 > k) {
        //     int distL = Math.abs(arr[low] - x);
        //     int distH = Math.abs(arr[high] - x);

        //     if(distL > distH) {
        //         low++;
        //     } else {
        //         high--;
        //     }
        // }



        // Binary Search Solution
        int n = arr.length;
        int low = 0;
        int high = n - k;

        while(low < high) {
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid + k] - x;

            if(distS > distE) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;

    }
}



# Problem 3 

Optimize of Routes (https://leetcode.com/discuss/interview-question/373202)


import java.io.*;

import java.util.ArrayList;

import java.util.List;

import java.util.Arrays;

class Solution{

public List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){

       List<int[]> output=new ArrayList<>();

       if(forward.length==0||backward.length==0||target==0){

           return output;

       }

       int max=0;

       Arrays.sort(backward,(a,b)->(a[1]-b[1]));

       for(int i=0;i<forward.length;i++){

           int index=binarySearch(backward,target-forward[i][1]);

           if(index!=-1){

               int sum=forward[i][1]+backward[index][1];

               if(sum>=max){

                   if(sum>max){

                       output=new ArrayList<>();

                   }

                   max=Math.max(max,sum);

                   output.add(new int[]{forward[i][0],backward[index][0]});

               }

           }

       }

       return output;

   }

   public int binarySearch(int[][] backward,int target){

       int left=0;

       int right=backward.length-1;

       while(left<right);

       int mid=left+(right-left)/2;

       if(backward[mid][1]==target){

           return mid;

       }

       else if(backward[mid][1]<target){

           left=mid;

       }

       else{

           right=mid-1;

       }

       return right;

   }

   public static void main(String[] args){

       Solution s =new Solution();

       int[][] forward= {{1, 2000}, {2, 4000}, {3, 6000}};

       int[][] backward={{1, 2000}};

       int target=7000;

       List<int[]> res=s.optimalAirRoute(forward,backward,target);

       if(res!=null){

           for(int i=0;i<res.size();i++){

           System.out.println(res.get(i)[0]+","+res.get(i)[1]);

       }

       }

   }

}