// Time Complexity : O(n) where n is the length of array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length-1;

        while(r-l+1>k){
            int distl = Math.abs(arr[l]-x);
            int distr = Math.abs(arr[r]-x);

            if(distl>distr){
                l++;
            }
            else{
                r--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=l;i<=r;i++){
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String [] args){
        KClosest kc = new KClosest();
        int [] arr = new int[]{1,2,3,4,5};
        System.out.println(kc.findClosestElements(arr,3, 3));
    }
}