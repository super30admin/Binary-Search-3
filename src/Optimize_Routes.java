/** maxTravelDist, it is an integer which represents the maximum operating travel distance of the given aircraft;
 	forwardRouteList, it is a list of pairs of integers where the first integer represents the unique identifier of a forward 
	shipping route and the second integer represents the amount of travel distance required by this shipping route;
	returnRouteList, a list of pairs of integers where the first integer represents the unique identifer of a return shipping route
	and the second integer represents the amount of travel distance required by this shipping route.

	These three things will be given as an input to you. you need to return a list of pairs of integers representing 
	the pairs of IDs of forward and also return the shipping routes that optimally utilize the given aircraft. 
	If no route is possible, return a list with empty pair. */

import java.util.*;
/***********************************************Brute Force********************************************/
//Time Complexity : O(n^2)
//Space Complexity :O(n)
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : No

public class Optimize_Routes {
	private static void getCoordinates_burte(List<List<Integer>> list1, List<List<Integer>> list2, int target) {
		int max = Integer.MIN_VALUE;
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0; i<list1.size(); i++) {
			int n1 = list1.get(i).get(1);
			for(int j=0; j<list2.size(); j++) {
				int n2 = list2.get(j).get(1);
				int sum = n1 + n2;
				if(sum == max) {
					List<Integer> temp = new ArrayList<>();
					temp.add(list1.get(i).get(0));
					temp.add(list2.get(j).get(0));
					result.add(temp);
				}
				if(sum > max && sum <= target) {
					max = sum;
					result.clear();
					List<Integer> temp = new ArrayList<>();
					temp.add(list1.get(i).get(0));
					temp.add(list2.get(j).get(0));
					result.add(temp);
				}
			}
		}
		System.out.println(max);
		for(List<Integer> list : result)
			System.out.println(list.get(0) + "\t" + list.get(1));
	}

	/***********************************************Using Two Pointer Approach********************************************/
	//Time Complexity : O(n)
	//Space Complexity :O(n)
	//Did this code successfully run on Leetcode : No
	//Any problem you faced while coding this : No
	private static void getCoordinates(List<List<Integer>> list1, List<List<Integer>> list2, int target) {
		int low = 0;
		int high = list2.size() - 1;
		List<List<Integer>> result = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		while(low <= list1.size() && high > 0) {
			int n1= list1.get(low).get(1);
			int n2= list2.get(high).get(1);
			int sum = n1 + n2;
			if(sum == max) {
				List<Integer> temp = new ArrayList<>();
				temp.add(list1.get(low).get(0));
				temp.add(list2.get(high).get(0));
				result.add(temp);
				low++;
				high--;
			}
			if(sum <= target && sum > max) {
				max = sum;
				result.clear();
				List<Integer> temp = new ArrayList<>();
				temp.add(list1.get(low).get(0));
				temp.add(list2.get(high).get(0));
				result.add(temp);
				low++;
				high--;
			}
			else if(sum < target)
				low++;
			else
				high--;		
		}
		System.out.println(max);
		for(List<Integer> list : result)
			System.out.println(list.get(0) + "\t" + list.get(1));

	}

	public static void main(String[] args) {
		List<List<Integer>> list1 = new ArrayList<>();
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2000);
		list1.add(l);
		l = new ArrayList<Integer>();
		l.add(2);
		l.add(3000);
		list1.add(l);
		l = new ArrayList<Integer>();
		l.add(3);
		l.add(4000);
		list1.add(l);

		List<List<Integer>> list2 = new ArrayList<>();
		l = new ArrayList<Integer>();
		l.add(1);
		l.add(1000);
		list2.add(l);
		l = new ArrayList<Integer>();
		l.add(2);
		l.add(3500);
		list2.add(l);
		l = new ArrayList<Integer>();
		l.add(3);
		l.add(4500);
		list2.add(l);
		getCoordinates(list1, list2, 7000);
		getCoordinates_burte(list1, list2, 7000);
	}
}
