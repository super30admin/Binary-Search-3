import java.util.*;
public class KClosest {
    //Binary serach method:O(log(n-k))
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        while(low<high){
            int mid = low+(high-low)/2;

            int distS = x-arr[mid];
            int distE = arr[mid+k]-x;
            if(distS>distE){
                low = mid+1;
            }
            else{
                high=mid;
            }
        }
        //add k elements between low and high to result
        List<Integer> result = new ArrayList<>();
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }


    //    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int low = 0;
//        int high = arr.length-1;
//        while(high-low+1>k){
//            int distLow = Math.abs(x-arr[low]);
//            int distHigh = Math.abs(arr[high]-x);
//            if(distLow>distHigh){
//                low++;
//            }
//            else{
//                high--;
//            }
//        }
//        //add k elements between low and high to result
//        List<Integer> result = new ArrayList<>();
//        for(int i=low;i<=high;i++){
//            result.add(arr[i]);
//        }
//        return result;
//    }
}
