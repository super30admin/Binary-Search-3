// Time Complexity :O(n-k)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
        int low =0;
        int high = n-k;

        while(low<high){
            int mid = low+(high-low)/2;

            int start = x-arr[mid];
            int end= arr[mid+k]-x;

            if(start>end){
                low=mid+1;
            }else{
                high=mid;
            }
        }

        List<Integer> res= new ArrayList<>();
        for(int i=low; i<low+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
