//Time Complexity: O(forwardRoutes * ReturnRoutes)
//Space Complexity: O(forwardRoutes * ReturnRoutes)
import java.util.*;

class OptimizeAirRoutes {

    private List<int[]> findOptimizedRoute(int maxTravelDist, List<int[]> forwardRouteList, List<int[]> returnRouteList) {
        List<int[]> optimalRoutes = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        for(int[] forwardR: forwardRouteList) {
            for(int[] returnR: returnRouteList) {
                if(forwardR[1] + returnR[1] <= maxTravelDist) {
                    pq.add(new int[]{forwardR[0], returnR[0],forwardR[1] + returnR[1]});
                }
            }
        }
        if(!pq.isEmpty()) {
            int[] optimalR = pq.poll();
            int optimal = optimalR[2];
            optimalRoutes.add(new int[]{optimalR[0], optimalR[1]});
            while(!pq.isEmpty()) {
                int[] temp = pq.poll();
                if(temp[2] == optimal) {
                    optimalRoutes.add(new int[]{temp[0], temp[1]});
                } else {
                    break;
                }
            }

        }
        return optimalRoutes;
    }

    private static void print(List<int[]> res) {
        System.out.print("[");
        for(int[] r : res) {
            System.out.print("["+r[0]+","+r[1]+"]");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        OptimizeAirRoutes oar = new OptimizeAirRoutes();
        List<int[]> forwardRouteList = new ArrayList<>();
        forwardRouteList.add(new int[]{1, 2000});
        forwardRouteList.add(new int[]{2, 4000});
        forwardRouteList.add(new int[]{3, 6000});
        List<int[]> returnRoutList = new ArrayList<>();
        returnRoutList.add(new int[]{1,2000});
        List<int[]> res = oar.findOptimizedRoute(7000, forwardRouteList, returnRoutList);
        print(res);
//        [[2,1]]
        forwardRouteList = new ArrayList<>();
        forwardRouteList.add(new int[]{1, 3000});
        forwardRouteList.add(new int[]{2, 5000});
        forwardRouteList.add(new int[]{3, 7000});
        forwardRouteList.add(new int[]{4, 10000});
        returnRoutList = new ArrayList<>();
        returnRoutList.add(new int[] {1, 2000});
        returnRoutList.add(new int[] {2, 3000});
        returnRoutList.add(new int[] {3, 4000});
        returnRoutList.add(new int[] {4, 5000});
        res = oar.findOptimizedRoute(10000, forwardRouteList,returnRoutList);
        print(res);
//        [[2,4],[3,2]]
    }
}