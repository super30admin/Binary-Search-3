import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n-k) +O(k)
// Space Complexity : O(k)


public class problem2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n= arr.length;
        int low= 0, high=n-k;

        while(low<high)
        {
            int mid= low+(high-low)/2;
            int disS= x- arr[mid];
            int disE= arr[mid+k] -x;

            if(disS> disE)
            {
                low= mid+1;
            }
            else
            {
                high= mid;
            }
        }
        List<Integer> res= new ArrayList<>();
        for(int i=low;i<low+k;i++)
        {
            res.add(arr[i]);
        }
        return res;

    }
}
