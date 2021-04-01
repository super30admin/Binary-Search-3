import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
//tc : O(nlogn)
//sc: O(n); priorityqueue
public class KClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            else
                return a[0] - b[0];
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{Math.abs(arr[i] - x), arr[i]});
        }

        while (k > 0) {
            int[] temp = pq.poll();
            res.add((temp[1]));
            k--;
        }
        Collections.sort(res);

        return res;

    }
}
