import java.util.ArrayList;
import java.util.Arrays; 

class Problem3{

    // Method 1 - Brute Force
    // Time complexity - O(n^2)
    // Space complexity - O(1)

    public static ArrayList<int[]> optimizeAirRoutes1(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        // return null for invalid input
        if(forwardRouteList == null || forwardRouteList.length == 0 || returnRouteList == null || returnRouteList.length == 0)
            return null;
        int max = 0;
        ArrayList<int[]> result = new ArrayList<>();
        //for each distance in forward route find complement in return route
        for(int i=0; i<forwardRouteList.length; i++){
            for(int j=0; j<returnRouteList.length; j++){
                int dist = forwardRouteList[i][1] + returnRouteList[j][1] ;
                if(dist <= maxTravelDist){
                    if(dist < max)
                        continue;
                    // update new max distance and clear the entries of result array, fill with new entries
                    if(dist > max){
                        result = new ArrayList();
                    }
                    max = dist;
                    int[] ftemp = {forwardRouteList[i][0], returnRouteList[j][0] };
                    result.add(ftemp);
                }
            }
        }
        return result;
    }

    // Method 2 - using binary search
    // Time complexity - O(nlon) + O(k)
    // Space complexity - O(1)
    public static ArrayList<int[]> optimizeAirRoutes2(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        // return null for invalid input
        if(forwardRouteList == null || forwardRouteList.length == 0 || returnRouteList == null || returnRouteList.length == 0)
            return null;
        int max = 0;
        ArrayList<int[]> result = new ArrayList<>();
        // sort return route array
        Arrays.sort(returnRouteList,(a,b) -> a[1]-b[1]);

        //for each distance in forward route find the complement distance from the return route array
        for(int i=0; i<forwardRouteList.length; i++){
            int dist = maxTravelDist - forwardRouteList[i][1];
            int nearestIndex = findNearest(returnRouteList,dist);

            if(nearestIndex != -1){
                int sum = forwardRouteList[i][1] + returnRouteList[nearestIndex][1];
                // if sum of distance of forward and return route is greater than the max distance, 
                //reset max value and result array entries
                if(sum >= max){
                    if(sum > max){
                        result = new ArrayList<>();
                    }
                    max = Math.max(max,sum);
                    result.add(new int[]{forwardRouteList[i][0],returnRouteList[nearestIndex][0]});
                }
            }
        }
        return result;
    }

    // Helper method for method 2
    // This method return nearest index for any target which need to find in return route array.
    public static int findNearest(int[][] returnRouteList, int target){
        int nearest = -1;
        int start = 0, end = returnRouteList.length-1;

        //find nearest index
        while(start <= end){   
            int mid = start + (end-start)/2; 
            //target found        
            if(returnRouteList[mid][1] == target)
                return mid;
            // shift left if target is lesser than the element at mid index
            else if(returnRouteList[mid][1] > target){
                end = mid-1;
            }
            // shift right if target is target is greater than element at mid
            // Also set nearest with mid 
            else{
                nearest = mid;
                start = mid+1;
            }
        }
        return nearest;
    }

    public static void main(String[] args){
        int maxTravelDist = 7000;
        int[][] forwardRouteList = {{1,3000},{2,5000},{3,7000},{5,10000}};
        int[][] returnRouteList = {{1,2000},{2,3000},{3,4000},{4,5000}};
        ArrayList<int[]> result = Problem3.optimizeAirRoutes(maxTravelDist,forwardRouteList,returnRouteList);

        if(result != null){
            for(int i=0;i<result.size(); i++){
                System.out.println(result.get(i)[0] + " , "+ result.get(i)[1]);
            }
        }
    }
}

