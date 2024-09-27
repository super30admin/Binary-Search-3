/* package whatever; // don't place package name! */
//Time Complexity-O(mlogn)
//Space Complexity- O(1)

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
	public List<int[]> getCloserToTarget(int[][]list1,int[][]list2,int target)
	{
		List<int[]>output=new ArrayList();
		Arrays.sort(list2,(a,b)->a[1]-b[1]);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<list1.length;i++)
		{
			int diff=target-list1[i][1];
			int index=binarySearch(list2,diff);
			if(index!=-1)
			{
				int sum=list1[i][1]+list2[index][1];
				if(sum>max)
				{
					output=new ArrayList();
				}
				max=Math.max(max,sum);
				output.add(new int[]{list1[i][0],list2[index][0]});
			}

		}
		return output;

	}
	public int binarySearch(int[][]list,int target)
	{
		int low=0;
		int high=list.length-1;
		while(low<=high)
		{
			int mid=low+(high-low)/2;
			if(list[mid][1]<=target)
			{
				return mid;
			}
			else{
				high=mid-1;
			}
		}

		return -1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Solution s=new Solution();
		int[][] a = {{1, 2}, {2, 4}, {3, 6}};
		int[][] b = {{1, 2}};
        List<int[]>output=s.getCloserToTarget(a,b,7);
		for(int i=0;i<output.size();i++)
		{
			System.out.println(output.get(i)[0]+","+output.get(i)[1]);
		}

	}
}