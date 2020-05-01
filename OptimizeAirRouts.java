// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : NA
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.List;

public class OptimizeAirRouts {
    static class Pair{
        int forwardRoute;
        int returnRoute;

        public Pair(int forwardRoute, int returnRoute){
            this.forwardRoute = forwardRoute;
            this.returnRoute = returnRoute;
        }
    }

    public static List<Pair>  optimalRoute(int maxTravelDist, List<int[]> forwardRouteList, List<int[]> returnRouteList){
        List<Pair> result = new ArrayList<>();;
        int max = Integer.MIN_VALUE;
        for(int[] arr1 : forwardRouteList){
            for(int[] arr2: returnRouteList){
                int sum = arr1[1] + arr2[1];
                if(sum <= maxTravelDist){
                    if(sum > max){
                        max = sum;
                        result = new ArrayList<>();
                        result.add(new Pair(arr1[0], arr2[0]));
                    } else if(sum == max) {
                        result.add(new Pair(arr1[0], arr2[0]));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){

        int maxTravelDist = 10000;

        List<int[]> forwardRouteList = new ArrayList<>();

        forwardRouteList.add(new int[]{1,3000});
        forwardRouteList.add(new int[]{2,5000});
        forwardRouteList.add(new int[]{3,7000});
        forwardRouteList.add(new int[]{4,10000});

        List<int[]> returnRouteList = new ArrayList<>();
        returnRouteList.add(new int[]{1,2000});
        returnRouteList.add(new int[]{2,3000});
        returnRouteList.add(new int[]{3,4000});
        returnRouteList.add(new int[]{4,5000});

        List<Pair> pairs = optimalRoute(maxTravelDist,forwardRouteList,returnRouteList);

        for(Pair p : pairs){
            System.out.println("["+p.forwardRoute+","+p.returnRoute+"]");
        }
    }
}
