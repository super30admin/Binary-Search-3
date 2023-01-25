import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// Time O(NlogK)
// Space O(N)

public class KClosestElements {
	  // Heap Solution 
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       
        // take a map to store distances 
        Map<Integer,Integer> map = new HashMap<>();   
        for(int i=0;i<arr.length;i++){
            int dist = Math.abs(arr[i]-x);
            map.put(i,dist);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if(distA ==distB){
                return b-a;
            }else{
                return distB- distA;
            }
        });
        
       for(int i=0;i<arr.length;i++){
          pq.add(i);
           if(pq.size()>k){
                pq.poll();    
           }
       }
       List<Integer> result = new ArrayList<>();
        
        while(!pq.isEmpty()){
            result.add(arr[pq.poll()]);
        }
        Collections.sort(result);
        return result;
    }
}
