// TC: O(log(N - k) + k) since we are doing binary search on the array for only k elements in array and loop through the K elements to store the result
// SC: O(1) constant space

// We keep comparing the distance between x- nums[mid] ~ nums[mid+k] - x, given the current range ([i, i+k-1]).
//1. arr[mid] and arr[mid+k] are both larger than x; then x-arr[mid] is negative and arr[mid+k]-x is positive, this case we should assign hi = mid.
// 2. arr[mid] and arr[mid+k] are both less than x; then x-arr[mid] is positive and arr[mid+k]-x is negative, this case we should assign lo = mid.
// 3 arr[mid] < x < arr[mid+k]; in this case they are both positive and we should choose the closer one.

import java.util.*;

public class kClosestElements {

	public List<Integer> kClosest(int[] nums, int k , int x){
		
		int left = 0,right = nums.length-k;
		List<Integer> res = new ArrayList<>();
		
		while(left < right) {
			int mid = left+(right-left)/2;
			
			if(x - nums[mid] > nums[mid+k]- x)
				left = mid+1;
			else
				right = mid;
		}
		for(int i = left; i < left+k;i++) {
			res.add(nums[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		kClosestElements kc = new kClosestElements();
		int[] nums = {1,2,3,4,5};
		List<Integer> res = kc.kClosest(nums, 4, -1);
		System.out.println(res);
	}
}
