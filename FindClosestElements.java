package week7.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution3 obj = new Solution3();
		//int[] arr = { 1, 2, 4, 8, 10, 13, 14, 16, 20, 25 };
		//List<Integer> re = obj.findClosestElements(arr, 4, 12);
		int[] arr = { 1, 2, 4, 6, 8, 9, 10};
		List<Integer> re = obj.findClosestElements(arr, 3, 8);
		System.out.println(re);
	}
}
class Solution3 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			int disA = Math.abs(a - x);
			int disB = Math.abs(b - x);
			if (disA == disB)
				return b - a;
			else
				return disB - disA;

		});
		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
			if (pq.size() > k)
				System.out.println(pq);
				pq.poll();
		}
		List<Integer> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(pq.poll());
		}
		Collections.sort(result);
		return result;
	}
}
