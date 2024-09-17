// Time complexity - O(m+n)
// Space complexity - O(1)

// Two pointers

import java.util.ArrayList;
import java.util.List;

public class AmazonInterviewProblem {

	public static void main(String[] args) {
		List<List<Integer>> list1 = new ArrayList<>();
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2000);
		list1.add(l);
		l = new ArrayList<Integer>();
		l.add(2);
		l.add(4000);
		list1.add(l);
		l = new ArrayList<Integer>();
		l.add(3);
		l.add(6000);
		list1.add(l);

		List<List<Integer>> list2 = new ArrayList<>();
		l = new ArrayList<Integer>();
		l.add(1);
		l.add(1000);
		list2.add(l);
		l = new ArrayList<Integer>();
		l.add(2);
		l.add(2500);
		list2.add(l);
		l = new ArrayList<Integer>();
		l.add(3);
		l.add(5000);
		list2.add(l);
		getCoordinates(list1, list2, 7000);
	}

	private static void getCoordinates(List<List<Integer>> list1, List<List<Integer>> list2, int target) {
		int low = 0;
		int high = list2.size() - 1;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int max = Integer.MIN_VALUE;
		while (low <= list1.size() && high >= 0) {
			System.out.println(1);
			int t1 = list1.get(low).get(1);
			int t2 = list2.get(high).get(1);
			int sum = t1 + t2;
			if (sum == max) {
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(list1.get(low).get(0));
				tmp.add(list2.get(high).get(0));
				res.add(tmp);
				low++;
				high--;
			}
			if (sum <= target && sum > max) {
				max = sum;
				res.clear();
				List<Integer> tmp = new ArrayList<Integer>();
				tmp.add(list1.get(low).get(0));
				tmp.add(list2.get(high).get(0));
				res.add(tmp);
				low++;
				high--;
			} else if (sum < target) {
				low++;
			} else {
				high--;
			}
		}

		System.out.println(max);
		for (List<Integer> l : res) {
			System.out.println(l.get(0) + "\t" + l.get(1));
		}
	}

}
