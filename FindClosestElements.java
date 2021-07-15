import java.util.*;

/**
 * @author Vishal Puri
 * // Time Complexity : O(nlogk)
 * // Space Complexity : O(logk)
 * // Did this code successfully run on Leetcode : Yes
 * // Any problem you faced while coding this :
 */

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        int len = nums.length, count = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        for (int i = 0; i < len; i++) {
            if (count < k) {
                count++;
                heap.offer(new int[] { Math.abs(nums[i] - x), nums[i] });
            } else {
                if (Math.abs(nums[i] - x) >= heap.peek()[0])
                    continue;
                heap.remove();
                heap.offer(new int[] { Math.abs(nums[i] - x), nums[i] });
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!heap.isEmpty())
            ans.add(heap.remove()[1]);

        Collections.sort(ans);
        return ans;
    }
}
