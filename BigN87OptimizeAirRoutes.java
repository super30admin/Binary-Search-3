// Time complexity is O(nlogm)
// Space complexity is O(1)
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.List;

public class BigN87OptimizeAirRoutes {
	public List<int[]> optimize(int [][] forward, int [][] backward, int target){
		//egde case
		List<int[]> result = new ArrayList<>();
		if(forward == null || forward.length ==0)
			return result;
		//putting one pointer on
		int [] temp = new int[2];
		for(int i = 0;i<forward.length;i++) {
			int max = 0;
			int complement = target -forward[i][1];
			int val = binarySearch(backward, complement);
			if(val!=-1) {
				int sum = val+ forward[i][1];
				if(sum>max) {
					max = sum;
					temp[0]=(forward[i][0]);
					temp[1] =(backward[val][0]);
				}
			}
		}
		
		result.add(temp);
		return result;
		//return new ArrayList<>();
	}

	private int binarySearch(int[][] arrays, int target) {
		int low = 0;
		int high = arrays.length-1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arrays[mid][1] == target)
				return arrays[mid][1];
			else if (arrays[mid][1] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return high;
	}
	public static void main(String [] args) {
		BigN87OptimizeAirRoutes op  = new BigN87OptimizeAirRoutes();
		int [][] forward = {{1,2000},{2,4000},{3,6000}};
		int [][] backward = {{1,2000}};
		int target = 7000;
		List<int[]> yo = op.optimize(forward, backward, target);
		for(int[] k: yo) {
			for(int j =0;j<k.length;j++)
				System.out.println(k[j]);
		}
			
	}
}
