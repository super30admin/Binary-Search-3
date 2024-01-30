//TC O(log(n-k)+O(k))
//SC O(1)

import java.util.ArrayList;
import java.util.List;
/*
Binary Search solution
 */
class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
                return res;
        int low = 0, high = arr.length -k;
        while(low<high){ //O(log(n-k))
            int mid = low + (high-low)/2;
            int distL = Math.abs(x-arr[mid]);
            int distR = Math.abs(x-arr[mid+k]);
            if(distL>distR)
                low = mid+1;
            else
                high = mid;
        }
        for(int i=low;i<low+k;i++){
            res.add(arr[i]);
        }
        return res;
    }
}