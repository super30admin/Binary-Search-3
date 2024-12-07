import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosest{
//Heap logic
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low =0, high = n-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(x-a);
            int distB = Math.abs(x-b);
            if(distA == distB){
                return b-a;
            }
            return distB-distA;
        });
        for(int num: arr){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }

    //two pointers logic 
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int n = arr.length;
    //     int low =0, high = n-1;
    //     while(high - low + 1 > k){
    //         int distL = Math.abs(arr[low] - x);
    //         int distH = Math.abs(arr[high]-x);
    //         if(distL > distH){
    //             low++;
    //         }else{
    //             high--;
    //         }
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     for(int i = low; i <= high; i++){
    //         result.add(arr[i]);
    //     }

    //     return result;
    // }

    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     int n = arr.length;
    //     int low =0, high = n-k;
    //     while(low < high){
    //         int mid = low + (high - low)/2;
    //         int distS = x - arr[mid];
    //         int distE = arr[mid+k] - x;
    //         if(distS > distE){
    //             low = mid + 1;
    //         }else{
    //             high = mid;
    //         }
    //     }
    //     List<Integer> result = new ArrayList<>();
    //     for(int i = low; i < low+k; i++){
    //         result.add(arr[i]);
    //     }

    //     return result;
    // }
}