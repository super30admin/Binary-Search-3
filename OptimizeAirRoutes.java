//Approach: Brute Force
//Time complexity: O(n^2)
// Space complexity: O(1)
class Solution{
    public static ArrayList<int[]> optimizeAirRoutes(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
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
                    // update new max distance and fill new entries
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
}



// Approach: Binary Search, We first sort the input, the iterate over each distance in forward route, find the complement distance from the return route array
// Time complexity - O(NlogN)
// Space complexity - O(1)

    public static ArrayList<int[]> optimizeAirRoutes(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        if(forwardRouteList == null || forwardRouteList.length == 0 || returnRouteList == null || returnRouteList.length == 0)
            return null;
        int max = 0;
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(returnRouteList,(a,b) -> a[1]-b[1]);
        for(int i=0; i<forwardRouteList.length; i++){
            int dist = maxTravelDist - forwardRouteList[i][1];
            int nearestIndex = findNearest(returnRouteList,dist);

            if(nearestIndex != -1){
                int sum = forwardRouteList[i][1] + returnRouteList[nearestIndex][1];
                //if sum of distance of forward and return route is greater than the max distance
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
