// for two pointer based solution
// Time Complexity : O(n -k) + O(K) i.e while loop to adjust left and right + for loop to go over final left to right

// for binary search based solution
// Time Complexity : O(Log(n-k)) to search start of window + O(k) to go over the window

// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

package com.madhurima;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    //two pointer based solution, move pointers left and right until distance between them is k
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(right - left + 1 > k){
            int distLeft = x - arr[left];
            int distRight = arr[right] - x;

            if(distLeft > distRight){
                left++;
            }else{
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            result.add(arr[i]);
        }

        return result;

    }


    //Binary search based solution
    public List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }

        int n = arr.length;
        int low = 0;
        int high = n-k; //as from this point we need k elements

        while(low < high){
            int mid = low + (high - low)/2; //to avoid integer overflow //mid is the new start
            int distStart = x - arr[mid];
            int distEnd = arr[mid+k] - x;

            if(distStart > distEnd){
                low = mid + 1;
            }else{
                high = mid;
            }

        }

        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }

        return result;

    }


}
