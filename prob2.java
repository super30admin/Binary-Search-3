// Time Complexity : O(1lgn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes


import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-k;
        while(left<right) {
            int mid = (left+right)>>1;
            if(x-arr[mid]>arr[mid+k]-x) left = mid+1;
            else right = mid;
        }
        return new MyList(arr, left, left+k);
    }
    class MyList extends AbstractList<Integer> {
        private int[] arr;
        private int left;
        private int right;

        public MyList(int[] arr, int left, int right) {
            this.arr = arr;
            this.left = left;
            this.right = right;
        }
        @Override
        public Integer get(int index) {
            return arr[left+index];
        }
        @Override
        public int size() {
            return right-left;
        }
    }
}