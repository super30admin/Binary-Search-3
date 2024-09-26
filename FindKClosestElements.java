import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null || arr.length==0) {
            return new ArrayList<>();
        }
        int low =0;
        int high = arr.length-k;
        List<Integer> list = new ArrayList<>();
        while(low<high){
            int  mid = low + (high-low)/2;
            int distS = x-arr[mid];
            int distE= arr[mid+k] - x;
            if(distS>distE){
                low=mid+1;
            }else{
                high = mid;
            }

        }
        for(int i=low; i<low+k;i++){
            list.add(arr[i]);
        }
        return list;

    }
}
