import java.util.*;

//TimeComplexity :: O(n-k) as we only parse through those elements until we reach the closes elements
//SpaceComplexity:: O(1) No other extra space is used, resultList is not considered

//used two pointers and moved the pointers closer to the target number by check the difference between the current number at pointer and target number
//if the difference is same at both the pointers then move the pointer whose number is greater

class Solution {
    public List<Integer> KClosestElements(int[] arr, int k, int x) {
        int l = arr.length;
        int p1 = 0;
        int p2 = l - 1;

        while (p2 - p1 + 1 > k) {
            int sum1 = Math.abs(arr[p1] - x);
            int sum2 = Math.abs(arr[p2] - x);

            if (sum1 > sum2) {
                p1++;
            } else if (sum1 < sum2) {
                p2--;
            } else {
                if (arr[p1] < arr[p2]) {
                    p2--;
                } else {
                    p1++;
                }
            }

        }

        List<Integer> resultL = new ArrayList<>();
        for (int j = p1; j <= p2; j++) {
            resultL.add(arr[j]);
        }

        return resultL;
    }
}