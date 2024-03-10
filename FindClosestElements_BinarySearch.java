package week7.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestElements_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution8 obj = new Solution8();
		 int[] arr = { 1, 2, 4, 8, 10, 13, 14, 16, 20, 25 };
		 List<Integer> re = obj.findClosestElements(arr, 4, 12);
		//int[] arr = { 1, 1, 1, 10, 10, 10 };
		//List<Integer> re = obj.findClosestElements(arr, 1, 9);
		System.out.println(re);
	}
}

class Solution8 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		int low = 0;
		int high = arr.length - k;
		int middle;
		while (low != high) {
			middle = low + (high - low) / 2;
			int startIdx = x - arr[middle];
			int endIdx = arr[middle + k] - x;
			if (startIdx > endIdx) {
				low = middle + 1;
			} else {
				high = middle;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = low; i < low + k; i++) { // start from low and end- low+k
			result.add(arr[i]);
		}
		return result;
	}
}
