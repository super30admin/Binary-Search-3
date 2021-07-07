import java.util.*;
/*************************Using Binary Search************************/
//Time Complexity : O(logn - k)
//Space Complexity :O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        
        int low=0;
        int high = arr.length -k;
        while(low < high){
            int mid = low + (high-low)/2;
            int distL = Math.abs(x - arr[mid]);	// find distance of window starting at mid
            int distR = Math.abs(x - arr[mid + k]);// find distance of window ending at mid+k
            
            if(distL > distR)	// if distance of start of window is high
                low = mid +1;
            else{
                if(arr[mid] == arr[mid + k])	// if duplicates exist
                    low = mid +1;
                else
                    high = mid;
            }
        }
        for(int i=low; i<low+k; i++)
            result.add(arr[i]);
        
        return result;
    }
}

/*************************Using Two Pointer Approach************************/
//Time Complexity : O(n-k) + O(k) = O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class FindK_Closest_Elements_Two_Pointer {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if(arr == null || arr.length == 0)
			return result;

		int low=0;
		int high = arr.length -1;
		while(high-low +1 > k){
			int distL = Math.abs(x - arr[low]);	// find absolute distance of x from the number at low
			int distR = Math.abs(x - arr[high]);// find absolute distance of x from the number at high

			if(distL > distR)	// if distance at low is higher
				low++;	// we need to go to smaller distances so move low pointer
			else 
				high--;	// else move high

		}
		for(int i=low; i<low+k; i++)	 // go from low to k elements and add to result
			result.add(arr[i]);

		return result;
	}
}
/***********************Using Priority Queue(Max Heap)**********************/
//Time Complexity : O(n log k)
//Space Complexity :O(k)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class FindK_Closest_Elements_PQ {
	class Pair{
		int key;
		int value; 
		public Pair(int key, int value){
			this.key = key;
			this.value = value;
		}
	}
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
			if(a.key == b.key)
				return b.value - a.value;
			else
				return b.key - a.key;
		});
		for(int i=0; i<arr.length; i++){
			pq.add(new Pair(Math.abs(x - arr[i]), arr[i]));

			if(pq.size() > k)
				pq.poll();
		}

		List<Integer> result = new ArrayList<>();
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			result.add(p.value);
		}
		Collections.sort(result);
		return result;
	}
}
