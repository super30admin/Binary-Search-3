/*
TC: O(log(N-K)); N - number of elements in array, k - closest elements
SC: O(K)

1. As the given array is sorted, we will use the property of binary search to find closest elements. 
2. A window is fixed by determining low and high pointers.
3. Window is moved right or left based on the distance between x and element at mid. 
4. If x - arr[mid] > arr[mid + k] - x; closest elements are found to the right. Hence, move low. 
5. Else, closer elements are found to the left. Move window to the left. High pointer is moved towards mid. 
6. The search space is reduced in every iteration. Hence, O(log(N- K)).
*/

import java.util.*;
import java.util.stream.Collectors;
public class KClosest {
    
    public List<Integer> closestElements(int[] nums, int k, int x){

        int low = 0, high = nums.length - k;

        while(low < high){

            int mid = (high + low) / 2;
            if( x - nums[mid] > nums[mid + k] - x){
                low = mid + 1;
            }else{
                high = mid;
            }
        }

        return Arrays.stream(nums, low, low + k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args){
        KClosest kcloset = new KClosest();

        int[] nums = new int[]{1,2,3,4,5};
        int k = 3, x = 3;
        System.out.println(kcloset.closestElements(nums, k, x));
    }
}
