//Time Complexity:O(M+NlogN) where M is the size of the forward list and N is the size of the backward list.
//Space Complexity:O(M+N)
//In this problem, I'll be sorting the backward list in the order of increasing distances. Then, I'll be calling binary serach function, that will help me find the nearest index in the backward list whose sum with the current element in the forward list is close to the target. I'll then be checking if the index returned by the binary search funtion is not -1(corner case: ran into out of bounds exception at this place), I'll be calculation the sum of the current element in the forward index and the nearest index element in the backward list. If this sum is greater than or equal to the preset max, I'll be updating the max value to be the max of previous max and the sum and add the corresponding forward and backward list elements into the output list.
//This code was executed successfully and produced the correct output. 
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution{
 public List<int[]> optimalAirRoute(int[][]forward,int[][] backward, int target){
        List<int[]> output=new ArrayList<>();
        if(forward.length==0||backward.length==0||target==0){
            return output;
        }
        int max=0;
        Arrays.sort(backward,(a,b)->(a[1]-b[1]));
        for(int i=0;i<forward.length;i++){
            int index=binarySearch(backward,target-forward[i][1]);
            if(index!=-1){
                int sum=forward[i][1]+backward[index][1];
                if(sum>=max){
                    if(sum>max){
                        output=new ArrayList<>();
                    }
                    max=Math.max(max,sum);
                    output.add(new int[]{forward[i][0],backward[index][0]});
                }
            }
        }
        return output;
    }
    public int binarySearch(int[][] backward,int target){
        int left=0;
        int right=backward.length-1;
        while(left<right);
        int mid=left+(right-left)/2;
        if(backward[mid][1]==target){
            return mid;
        }
        else if(backward[mid][1]<target){
            left=mid;
        }
        else{
            right=mid-1;
        }
        return right;
    }
    public static void main(String[] args){
        Solution s =new Solution();
        int[][] forward= {{1, 2000}, {2, 4000}, {3, 6000}};
        int[][] backward={{1, 2000}};
        int target=7000;
        List<int[]> res=s.optimalAirRoute(forward,backward,target);
        if(res!=null){
            for(int i=0;i<res.size();i++){
            System.out.println(res.get(i)[0]+","+res.get(i)[1]);
        }
        }
        
    }
}