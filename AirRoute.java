
// Time Complexity :  O(min((m+n)logm), ((m+n)logn))
// Space Complexity : O(1) since it is iterative binary search.
// Did this code successfully run on Leetcode : Yes Its working
// Any problem you faced while coding this : No

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirRoute {
    int[][] forwardList;
    int[][] returnList;
    int maxDistance;

    AirRoute(int[][] forwardList, int[][] returnList, int maxDistance)
    {
        this.forwardList = forwardList;
        this.returnList=returnList;
        this.maxDistance = maxDistance;
    }

    private int binarySearch(int target) {
        int low = 0;
        int high = forwardList.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (forwardList[mid][1] == target)
                return mid;
            else if (forwardList[mid][1] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }

    public List<List<Integer>> getOptimizeRoute() {
        List<List<Integer>> result = new ArrayList<>();
        if (forwardList == null || returnList == null)
            return result;
        boolean flag = false;
        if (forwardList.length > returnList.length) {
            int[][] temp = forwardList;
            this.forwardList = this.returnList;
            this.returnList = temp;
            flag = true;
        }

        Arrays.sort(forwardList, (a, b) -> {
            return a[1] - b[1];
        });
        int max = Integer.MIN_VALUE;
        for (int[] data : returnList) {
            int target = maxDistance - data[1];
            int index = binarySearch(target); // get the index closest element
            if (index != -1) {
                int sum = data[1] + forwardList[index][1];
                if (sum >= max && sum <= maxDistance) {
                    if (sum > max)
                        result = new ArrayList<>(); // reset output list for new sum
                    max = Math.max(max, sum);
                    if(flag) // take care of list switch
                    {
                        result.add(new ArrayList<>(Arrays.asList(data[0], forwardList[index][0] ) ));
                    }
                    else
                    {
                        
                        result.add(new ArrayList<>(Arrays.asList( forwardList[index][0] ,data[0]) ));
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        // int[][] forwardRouteList = {{1,2000},{2,4000},{3,6000}};
        // int[][] returnRouteList = {{1,2000}};
        // AirRoute obj = new AirRoute(forwardRouteList, returnRouteList, 7000);
        // System.out.println(obj.getOptimizeRoute());
        int[][] forwardRouteList = { { 1, 3000 }, { 2, 5000 }, { 3, 7000 }, { 4, 10000 } };
        int[][] returnRouteList = { { 1, 2000 }, { 2, 3000 }, { 3, 4000 }, { 4, 5000 } };
        AirRoute obj = new AirRoute(forwardRouteList, returnRouteList, 10000);
        System.out.println(obj.getOptimizeRoute());

     
    }

}
