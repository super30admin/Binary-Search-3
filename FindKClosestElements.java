import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

//Leeetcode - 658
public class FindKClosestElements {
    //heap solution - NlogK
    /*public List<Integer> findClosestElements(int[] arr, int k, int x) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            map.put(i, Math.abs(x - arr[i]));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if(distA == distB){
                return b-a;
            }
            return distB - distA;
        });
        for(int i=0; i<arr.length; i++) {
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(arr[pq.poll()]);
        }
        Collections.sort(result);
        return result;
    }*/


    //2-pointers - NlogK

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int l =0;
        int h=arr.length-1;
        while(h-l+1 > k) {
            int distL = Math.abs(arr[l] - x);
            int distH = Math.abs(arr[h] - x);
            if(distL > distH) {
                l++;
            } else {
                h--;
            }
        }
        for(int i=l; i<=h; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
