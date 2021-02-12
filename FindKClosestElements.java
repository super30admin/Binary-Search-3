import java.util.LinkedList;
import java.util.List;
// Time Complexity :O(logn+k)
// Space Complexity :O(logk)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach

public class FindKClosestElements {


    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            LinkedList<Integer> result = new LinkedList<>();
            if(arr == null || arr.length == 0) return result;//edge cases

            int closest = binarySearch(arr, x);
            result.addFirst(arr[closest]);
            int left = closest-1;
            int right = closest +1;

            while(k>1){
                if(left < 0){ //if at first position
                    result.addLast(arr[right++]);
                } else if(right == arr.length){ //if at last position
                    result.addFirst(arr[left--]);
                }else{//if somewhere btween first and last element
                    if(x -arr[left] <= arr[right] - x){
                        result.addFirst(arr[left--]);
                    }else{
                        result.addLast(arr[right++]);
                    }
                }
                k--;
            }
            return result;
        }

        private int binarySearch(int[] arr, int x){
            int low=0, high=arr.length-1;//create pointers
            while(low<high){
                int mid = low + (high - low)/2;
                if(arr[mid] == x) return mid;
                else if(arr[mid] < x){
                    low = mid+1;
                }else{
                    high = mid;
                }
            }
            if(low ==0 ) return low;
            if(Math.abs(arr[low]-x) < Math.abs(arr[low-1]-x)) return low;
            return low -1;
        }
    }


}