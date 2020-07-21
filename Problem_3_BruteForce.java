// Time complexity - O(nm)
// Space complexity - O(1)

// Check for all comnibations

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
		getCoordinates2(list1, list2, 7000);

	}

	private static void getCoordinates2(List<List<Integer>> list1, List<List<Integer>> list2, int target) {
		int max = Integer.MIN_VALUE;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (int i = 0; i < list1.size(); i++) {
			int n1 = list1.get(i).get(1);
			for (int j = 0; j < list2.size(); j++) {
				int n2 = list2.get(j).get(1);
				int sum = n1 + n2;
				if (sum == max) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(list1.get(i).get(0));
					tmp.add(list2.get(j).get(0));
					res.add(tmp);
				}
				if (sum > max && sum <= target) {
					max = sum;
					res.clear();
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(list1.get(i).get(0));
					tmp.add(list2.get(j).get(0));
					res.add(tmp);
				}
			}
		}
		System.out.println(max);
		for (List<Integer> l : res) {
			System.out.println(l.get(0) + "\t" + l.get(1));
		}
	}

}
