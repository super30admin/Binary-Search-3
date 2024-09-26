import java.io.*;
import java.util.* ;

class Solution{
    public List<int[]> optimalRoute(int[][] forward , int target , int[][] backward){
        List<int[]> output = new ArrayList<>();
        if(forward.length == 0 || backward.length == 0 || target == 0){
            return output;
        }
        int max = 0;
        //sorting the backward array ;
        Arrays.sort(backward, (a,b)-> a[1] - b[1]) ;
        for(int i = 0 ; i < forward.length ; i++){
            // find target - forward[i][1]
            int index = binarySearch(backward , target - forward[i][1]);
            int sum = forward[i][1] + backward[index][1] ;
            if(sum >=max && sum <= target){
                if(sum > max){
                    output = new ArrayList<>();
                }
                max = sum ;
                output.add(new int[]{forward[i][0],backward[index][0]});
            }
        }
        return output;
    }
    private int binarySearch(int[][] backward , int target){
        int left = 0;
        int right = backward.length - 1 ;
        int mid;
        while(left < right){
            mid = left + (right- left/2) ;
            if(backward[mid][1] == target)
                return mid;
            else if(backward[mid][1] < target){
                left = mid ;
            }else{
                right = mid -1;
            }
        }
        return right ;
    }
}



public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] forward = {{1,8},{2,7},{3,14}};
        int[][] backward = {{1,5},{2,10},{3,14}};
        // int[][] forward = {{1,3},{2,5},{3,7},{4,10}};
        // int[][] backward = {{1,2},{2,3},{3,4},{4,5}};
        int target = 20 ;
        List<int[]> result = s.optimalRoute(forward ,target, backward);
        if(result!=null){
            for(int i = 0 ; i< result.size() ; i++){
                System.out.println(result.get(i)[0] + "," + result.get(i)[1]);
            }
        }
    }
}