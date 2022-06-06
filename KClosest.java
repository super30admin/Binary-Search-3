// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: 2 pointers and a window

import java.util.ArrayList;
import java.util.List;

public class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int i = 0;
        int j = arr.length - 1;
        while (j - i + 1 > k) {
            if (Math.abs(x - arr[i]) > Math.abs(x - arr[j])) {
                i++;
            } else {
                j--;
            }
        }
        while (i <= j) {
            res.add(arr[i]);
            i++;
        }
        return res;
    }
}
