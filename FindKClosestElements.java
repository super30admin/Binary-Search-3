package binarySearch3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {
	//Time Complexity : O(k + log(n - k)), where n are the number of elements in arr
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : Followed the lecture
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            int distL = x - arr[mid];
            int distH = arr[mid + k] - x;
            if(distL > distH)
                low = mid + 1;
            else
                high = mid;
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=low; i<low + k; i++)
            res.add(arr[i]);
        
        return res;
    }
	
	//Time Complexity : O(n), where n are the number of elements in arr
	//Space Complexity : O(1)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - 1;
        
        while(high - low + 1 > k) {
            int distL = Math.abs(arr[low] - x);
            int distH = Math.abs(arr[high] - x);
            
            if(distL > distH)
                low++;
            else
                high--;
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i=low; i<=high; i++)
            res.add(arr[i]);
        
        return res;
    }
	
	//Time Complexity : O(n log k)
	//Space Complexity : O(k)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for(int i=0; i<arr.length; i++) {
            maxHeap.offer(new int[] {arr[i], Math.abs(arr[i] - x)});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        List<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty())
            res.add(maxHeap.poll()[0]);
        Collections.sort(res);
        return res;
    }
}
