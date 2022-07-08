import java.util.*;
// TIme COmplexity: O(log(n-k))
// SPace Complexity: O(1)
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int h = n-k;
        while(l < h){
            int mid = l + (h-l)/2;
            int distL = x - arr[mid];
            int distR = arr[mid+k] - x;
            if(distL > distR){
                l = mid+1;
            }
            else h = mid;

        }
        List<Integer> result = new ArrayList<>();
        for(int i=l;i<l+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
