package org.example;

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n-k)+O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

public class FindKClosestElementsUsingTwoPointer {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-1;

        while(high-low+1>k)
        {
            int distS = x - arr[low];
            int distE = arr[high] - x;

            if(distS>distE)
            {
                low++;
            }else{
                high--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<=high; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}
