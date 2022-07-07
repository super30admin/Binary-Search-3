//Time Complexity: O(log (n-k))
//Space Complexity: O(1)
//Did this code run on LeetCode: Yes
//Approach: We are implementing binary search for an entire interval where instead of placing
//high at the last element, we are placing it on (n-k)th element.

import java.util.ArrayList;
import java.util.List;

public class Closest {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - k;
        
        while(low < high)
        {
            int mid = low + (high - low)/2;
            int disA = x - arr[mid];
            int disB = arr[mid + k] - x;
            
            if(disA > disB)
            {
                low = mid + 1;
            }
            else
            {
                high = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = low; i<low + k; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        List<Integer> print = new ArrayList<>();
        print = findClosestElements(arr, 4, 3);
        for(int i = 0; i<print.size();i++)
        {
            System.out.println(print.get(i));
        }
    }
}
