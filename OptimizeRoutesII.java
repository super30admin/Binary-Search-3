import java.util.*;
/*
TC: O(mlogm) + O(nlogm) m - length of backward array. sorting backward + binary search in backward array
SC: O(1)

1. Sort the smaller array.
2. Iterate through bigger array and try to find the complement of (target and bigger array value) in small.
3. Search through binary search technique. 
4. Keep closest max not greater than target in output.




*/
public class OptimizeRoutesII {
    public List<int[]> routes(int[][] forward, int[][] backward, int target){
        //base
        List<int[]> output = new ArrayList<>();
        if(forward == null || backward == null || target == 0) return output;

        Arrays.sort(backward, (a,b) -> (a[1]- b[1]));
        int max = 0;
         

        for(int i = 0; i < forward.length; i++){
            int idx = binarySearch(backward, target - forward[i][1]);
            if(idx != -1){
            int sum = forward[i][1] + backward[idx][1];
            if(sum > max){
                if(sum >= max){
                    output = new ArrayList<>();
                }
                output.add(new int[]{forward[i][0], backward[idx][0]});
            }
        }
    }
    return output;

    }

    private int binarySearch(int[][] backward, int target){
        int l = 0, h = backward.length - 1;

        while(l <= h){
            int mid = l + (h - l)/2;
            if(backward[mid][1] == target){
                return mid;
            }
            if(backward[mid][1] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return h;
    }
    public static void main(String[] args){
 
        OptimizeRoutes s =new OptimizeRoutes();
 
        int[][] forward= {{1,3},{2,5},{3,7},{4,10}};
 
        int[][] backward={{4,5},{3,4},{1,2},{2,3}};
 
        int target=10;
 
        List<int[]> res=s.optimalAirRoute(forward,backward,target);
 
        if(res!=null){
 
            for(int i=0;i<res.size();i++){
 
            System.out.println(res.get(i)[0]+","+res.get(i)[1]);
 
        }
 
        }
 
    }
}
