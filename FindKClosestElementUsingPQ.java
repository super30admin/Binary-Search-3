package org.example;

// Time Complexity : O(n log k))+O(k)
// Space Complexity : O(k)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElementUsingPQ {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            if(a[0] == b[0])
                return b[1]-a[1];
            return b[0] - a[0];
        });


        for(int i=0; i<arr.length; i++)
        {
            int dist = Math.abs(arr[i] - x);
            int[] temp = new int[2];
            temp[0] = dist;
            temp[1] = arr[i];
            pq.add(temp);
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        int size = pq.size();
        for(int i=0; i<size; i++)
        {
            result.add(pq.poll()[1]);
        }
        Collections.sort(result);
        return result;
    }
}
