    /*  Explanation
    # Leetcode problem link : https://leetcode.com/discuss/interview-question/373202
    Time Complexity for operators : o(nlogn) .. n is the length of the string
    Extra Space Complexity for operators : o(1)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) First sort the backward array on the basis of value. (mlogm)
                    B) Then iterate thru the first array and calculate the target that we have to find in the second array.
                    C) Apply binary search on the second array with target and second array to find the element.
                    D) Once we have index of element, get the  sum and check if it is greater than max. Need to maintain max.
                    E) if sum>max then create new arraylist and add then elemnts into it.
                    F) At the end, return list.
    */  
import java.util.*;
class Solution  {


public List<int[]> optimalAirRoute(int[][] forward, int[][] backward, int target){
    List<int[]> output = new ArrayList<>();

    int max = Integer.MIN_VALUE;
    Arrays.sort(backward, (a,b) -> a[1]-b[1]);

    for(int i=0;i<forward.length;i++){
        int current = forward[i][1];
        int find = target - current;

        int index = binarySearch(backward,find);

        if(index != -1){
            int sum = current + backward[index][1];

            if(sum > max){
                output = new ArrayList<>();
            }
            max = Math.max(max,sum);
            output.add(new int[]{forward[i][0],backward[index][0]});
        }
    }

    return output;
}

public int binarySearch(int[][] backward, int target){

    int left = 0;
    int right = backward.length-1;

    while(left<=right){
        int mid = left + (right-left)/2;

        if(backward[mid][1]==target){
            return mid;
        }else if(backward[mid][1]<target){
            left = mid + 1;
        }else{
            right = mid - 1;
        }
    }
    return right;
}


 public static void main(String[] args){
       Solution s =new Solution();
       int[][] forward= {{1, 2000}, {2, 4000}, {3, 6000}};
       int[][] backward={{1, 2000}, {2,4000}, {3,6000}, {4,7000}};
       int target=7000;
       List<int[]> res=s.optimalAirRoute(forward,backward,target);
       if(res!=null){
           for(int i=0;i<res.size();i++){
           System.out.println(res.get(i)[0]+","+res.get(i)[1]);
       }
       }
  }
}


// (base) Laxmikants-MacBook-Pro:Binary-Search-3 laxmikantbhaskarpandhare$ java Solution
// 1,2
// 2,1
// (base) Laxmikants-MacBook-Pro:Binary-Search-3 laxmikantbhaskarpandhare$ 
