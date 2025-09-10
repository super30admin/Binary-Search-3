import java.util.ArrayList;
import java.util.List;

public class KClosestElements {
    
//Idea is to use binary search to find the start element of the range.
//we compare the distance of elements arr[mid] and arr[mid+k] from target and 
//accordingly eliminate the range of elements

//Time Complexity: O(log(n-k)+k)
//Space Complexity: O(k)

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int n = arr.length;
      int low = 0, high = n-k;
      while(low<high)
      {
        int mid = low + (high - low)/2 ;

        int distS = x - arr[mid];
        int distE = arr[mid+k] - x;

        if(distS > distE)
        {
            low = mid + 1;
        }
        else
        {
           high = mid; 
        }
      } 

       List<Integer> result = new ArrayList<>();
        for(int i=low; i< low+k; i++){
            result.add(arr[i]);
        }

        return result; 
    }
}
