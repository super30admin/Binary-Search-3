// Time Complexity :O(M*N) -> M-forward routes N-backward routes
// Space Complexity :O(M)+O(N) --> two priority queues

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Put all forward routes into a priority queue(Max heap) and backward routes into a priority queue(Max heap).
// 2. For each element in forward queue ,  if its greater than max skip to next element. Else if its sum with element in backward queue is greater than sum
//    skip this element in backward queue.
// 3. Once we found a sum less than or equal to max update tempmax and add this combo to list. If sum less than tempmax then you can move to 
//    next element in forward queue.
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class optimizeAirRoutes {
    public static List<int[]> findRoutes(int max,int[][] forward,int[][] backward){
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> fpq = new PriorityQueue<>((int[] a,int[] b)-> b[1]-a[1]);
        PriorityQueue<int[]> rpq = new PriorityQueue<>((int[] a,int[] b)-> b[1]-a[1]);
        int tempmax = -1;
        for(int[] temp: forward)
            fpq.add(temp);
        for(int[] temp: backward)
            rpq.add(temp);
        while(!fpq.isEmpty()){
            PriorityQueue<int[]> temprpq = new PriorityQueue(rpq);
            int[] currentForward = fpq.poll();
            if(currentForward[1]>max)
                continue;
            while(!temprpq.isEmpty()){
                int[] currentBackward = temprpq.poll();
                if(currentBackward[1]>max || currentForward[1]+currentBackward[1]>max )
                    continue;
                if(currentForward[1]+currentBackward[1]>=tempmax){
                    tempmax = currentForward[1]+currentBackward[1];
                    result.add(new int[]{currentForward[0],currentBackward[0]});
                }
                else
                    break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] forwordRoutes = {{1,3000},{2,5000},{3,7000},{4,10000}};
        int[][] returnRoutes = {{1,2000},{2,3000},{3,4000},{4,5000}};
        int maxdistance = 5000;
        List<int[]> output = findRoutes(maxdistance,forwordRoutes,returnRoutes);
        for(int[] x:output)
            System.out.print("["+x[0]+","+x[1]+"]");
    }
}
