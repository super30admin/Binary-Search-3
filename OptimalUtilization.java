// TC: O(alogb + blogb) for sorting and iterating over the 2 arrays costs us O(a+b)
// SC : O(1) for constant space complexity


import java.util.*;

public class OptimalUtilization {

	public List<int[]> optimalUtilization(int[][] a, int[][] b, int target){
		
		Arrays.sort(a, (a1,a2)->a1[1]-a2[1]);  // Sort the array depending on the end values where we need to find our sum and compare it with target
		Arrays.sort(b, (b1,b2)-> b1[1] - b2[1]);
		List<int[]> result = new ArrayList<>();
		
		int n = a.length;
		int m = b.length;
		int i = 0, j = m-1;
		int max = Integer.MIN_VALUE;
		while(i < n && j >=0) {  // since we are doing search from the start and end of the second array so that we know which directions to move ahead
			
			int sum = a[i][1] + b[j][1];  // find the sum of the smallest from a and largest element from b, this will let us know, if we need to move ahead in a array and move back in b array 
			
			if( sum > target) {
				--j;  // if the sum is greater, we know we need to move the b array to the left.
			}else {
				if(max <= sum) {
						if( max < sum) {  // setting our max so that we know next time when we come, our sum not exceed our max value, it can be equal not exceed our max value
							max = sum;
							result.clear();  // we need to clear since we are checking from the last of b, if at any point we come across something greater than our max, we have our new result so that we can discard our previous result
						}
					
						result.add(new int[] {a[i][0], b[j][0]});  // ionce we have a solution where sum <= target, we add the first index values of a and b
						int index = j-1;  // there may be situation of combinations which might have same sum, we will add those if there is match for a array index with all values in b, 
						while(index >=0 && b[index][1] == b[index+1][1]) {
							result.add(new int[] {b[index][0], b[index--][0]});  // add all those values which have same sum but different startindex.
						}
				}
				i++;  // once we have a solution, move ahead in our a array
			}
		}
		return result;	  // return the result.
	}
	
	public static void main(String[] args) {
		
		OptimalUtilization ou = new OptimalUtilization();
		int[][] a = {{1, 8}, {2, 15}, {3, 9}};
		int[][] b = {{1, 8},{2, 11},{3, 12}};
		int target = 20;
		List<int[]> res = ou.optimalUtilization(a, b, target);
		for(int[] ab: res) {
			for(int ba: ab) {
				System.out.print(ba+" ");
			}
			System.out.println();
		}
	}
}
