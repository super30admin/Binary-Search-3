// Time Complexity : O(mlogn) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Brute force approach would be to search every possible pair with each ele from both the arrays and check for the closest to target
//Optimal would be to sort one array and implement binary search on it, to get the ele from second array
//traverse through first array and for every ele try to binary search on second array to find the closest to target
//if it find the target, add it to the output by clearing the list till then
//else add the closest possible pair to the target.


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class OptimizeRoutes{
    public static void main(String[] args){
       int[][] forward= {{1, 2000}, {2, 4000}, {3, 6000}};
       int[][] backward={{1, 2000}, {2,4000}, {3,6000}, {4,7000}};
       int target=7000;
       List<int[]> res=optimalAirRoute(forward,backward,target);
       if(res!=null){
           for(int i=0;i<res.size();i++){
           System.out.println(res.get(i)[0]+","+res.get(i)[1]);
       }
       }
    }
    public static List<int[]> optimalAirRoute(int[][] forward,int[][] backward, int target){
        List<int[]> res= new ArrayList<>();
        int max=Integer.MIN_VALUE;

        Arrays.sort(backward, (a,b)->a[1]-b[1]);
        for(int i=0;i<forward.length;i++){
            int curr=forward[i][1];
            int find=target-curr;

            int index=binSearch(backward,find);

            if(index!=-1){
                int sum=curr+backward[index][1];
                if(sum>max){
                    res=new ArrayList<>();
                }
                max=Math.max(sum,max);
                res.add(new int[]{forward[i][0],backward[index][0]});
            }
        }
        return res;
    }
    private static int binSearch(int[][] backward, int target){

        int l=0;
        int h=backward.length;

        while(l<=h){
            int mid=l+(h-l)/2;
            if(target==backward[mid][1]){
                return mid;
            }
            else if(target<backward[mid][1]){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return h;
    } 
    }

