package binarySearch3;

import java.util.LinkedList;
import java.util.List;

/*
The binary search will always position l in the smallest index of x, if x exists in the array. 
Otherwise l will be the index of smallest element larger than x. 
Then we can expand from that to collect k elements.

Note: After binary search, we need to make sure that one of the two pointers need to point at the element which is closest to x. 

TC : O(logn + k) where logn is for binary search over n elements in array and separate k for number of closest elements  
So if arr[l] > x, we point to l and l - 1, otherwise we point to l and l + 1.

*/

public class Find_k_closest_elements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] >= x) r = mid - 1;
            else l = mid + 1;
        }
        int cur = l;
        l = (arr[cur] > x) ? cur - 1 : cur;
        r = (l == cur) ? cur + 1 : cur;
        List<Integer> res = new LinkedList<>();
        while(k > 0) {
            if((l >= 0 && r < arr.length && Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) 
               || r > arr.length - 1)
                res.add(0, arr[l--]);
            else res.add(arr[r++]);
            k--;
        }
        return res;
    }
	
}
