// TC: O(log(n-k) + k)
// SC: O(1)

import java.util.*;
public class LC658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int s = 0;
        int e = n-k;
        while(s<e){
            int mid = (s+e) >> 1;
            if(x-arr[mid]>arr[mid+k]-x) s = mid + 1;
            else e = mid;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = s; i < s+k; i++) {
            list.add(arr[i]);
        }

        return list;
    }
}