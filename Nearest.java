
/**
 * time is O(n)
 * space is O(1)
 */

import java.util.*;

public class Nearest {
    List<Integer> result = new ArrayList<>();

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        if (arr == null || k <= 0)
            return result;
        if (arr.length <= k) {
            helper(arr, 0, k);
            return result;
        }

        int lowp = 0;
        int highp = arr.length - 1;

        while (highp - lowp >= k) {
            int highd = Math.abs(x - arr[highp]);
            int lowd = Math.abs(x - arr[lowp]);
            if (highd >= lowd)
                highp--;
            else
                lowp++;
        }
        helper(arr, lowp, k);

        return result;

    }

    private void helper(int[] arr, int index, int k) {

        for (int i = 0; i < k; i++) {
            result.add(arr[index]);
            index++;
        }
    }
}
