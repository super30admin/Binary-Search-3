import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;
        while(high - low + 1 > k){
            int distL = Math.abs(arr[low] - x);
            int distR = Math.abs(arr[high] - x);
            if(distL > distR) low++;
            else high--;
        }
        for(int i = low; i < low + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
