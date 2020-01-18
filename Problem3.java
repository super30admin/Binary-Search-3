// Time Complexity - mlogn 
// Space Complexity - O(1)
// Executed the code in local SDE

import java.util.*;
public class Optimize_Air_Routes {
	public static List<Integer> result = new ArrayList<>();
	public static void main(String args[]) {
		int target = 10000;
		int[][] forwardRouteList = {{1,3000},{2,5000},{3,7000},{4,10000}};
		int[][] returnRouteList = {{1,2000},{2,3000},{3,4000},{4,5000}};
		SearchPairs(forwardRouteList,returnRouteList,target);
		System.out.println(result.toString());
		
	}
	private static void SearchPairs(int[][] forwardRouteList,int[][] returnRouteList,int target) {
		int max =0;
		for(int i=0;i < forwardRouteList.length;i++ ) {
			int compliment = target - forwardRouteList[i][1];
			int BackIndx = BinarySearch(returnRouteList, compliment);
			if(BackIndx >= 0) {
				int sum = forwardRouteList[i][1] + returnRouteList[BackIndx][1];
				if(sum > max) {
					result = new ArrayList<>();
					max = sum;
					result.add(forwardRouteList[i][0]);
					result.add(returnRouteList[BackIndx][0]);
				}	
			}
		}
	}
	
	private static int BinarySearch(int[][] arr, int target ) {
		int low = 0;
		int high = arr.length -1;
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(arr[mid][1] == target)	return mid;
			else if(arr[mid][1] < target)	low = mid +1;
			else high = mid-1;
		}
		return low -1;
	}
}

