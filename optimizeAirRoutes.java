// Time Complexity : O(m + n) where m and n are the lengths of the forward and return route lists
// Also we assume that the routes are sorted in increasing order of distances
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

import java.util.*;
class optimizeAirRoutes {

	public static List<int[]> optimize(int maxDis, List<int[]> fwd, List<int[]> bwd) {
		int ptr1 = 0;
		int ptr2 = bwd.size() - 1;
		int p1 = ptr1;
		int p2 = ptr2;
		int max = Integer.MIN_VALUE;
		List<int[]> ans = new ArrayList<>();
		while (ptr1 < fwd.size() && ptr2 >= 0) {
			int sum = fwd.get(ptr1)[1] + bwd.get(ptr2)[1];
			if (sum == maxDis) {
				int[] arr = new int[2];
				arr[0] = fwd.get(ptr1)[0];
				arr[1] = bwd.get(ptr2)[0];
				ans.add(arr);
			}
			if (sum < maxDis) {
				max = Math.max(max, sum);
				p1 = ptr1;
				p2 = ptr2;
				ptr1++;
			} else {
				ptr2--;
			}
		}
		if (ans != null) return ans;
		int[] ar = new int[2];
		ar[0] = fwd.get(p1)[0];
		ar[1] = fwd.get(p2)[0];
		ans.add(ar);
		return ans;
	}

	private static int[] closestBinarySearch(List<int[]> moreLength, int low, int high, int num) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (moreLength.get(mid)[1] == num) {
				return moreLength.get(mid);
			} else if (moreLength.get(mid)[1] > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return moreLength.get(high);
	}

	public static void main(String[] args) {
		int maxDis = 10000;
		List<int[]> fwd = new ArrayList<>();
		List<int[]> bwd = new ArrayList<>();
		fwd.add(new int[] {1,3000});
		fwd.add(new int[] {2,5000});
		fwd.add(new int[] {3,7000});
		fwd.add(new int[] {4,10000});
		bwd.add(new int[] {1,2000});
		bwd.add(new int[] {2,3000});
		bwd.add(new int[] {3,4000});
		bwd.add(new int[] {4,5000});
		List<int[]> answer = optimize(maxDis, fwd, bwd);
		for (int[] l : answer) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}