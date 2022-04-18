/**
 * time complexity is O(nlogn)
 * space complexity is O(n)
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<Integer>();
        for (int num: arr) {
            res.add(num);
        }
        
        Collections.sort(res, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        res = res.subList(0, k);
        Collections.sort(res);
        return res;
    }
}