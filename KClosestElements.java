import java.util.*;


// Max heap O(n log k) + O(k log k) time, O(k) space
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> ans = new ArrayList<>();

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> { // dist from x, num
//             if (a[0] == b[0]) {
//                 return Integer.compare(b[1], a[1]);
//             }
//             else {
//                 return Integer.compare(b[0], a[0]);
//             }
//         });

//         for (int num : arr) {
//             int dist = Math.abs(num - x);
//             pq.offer(new int[] {dist, num});
//             if (pq.size() > k) {
//                 pq.poll();
//             }
//         }

//         while (!pq.isEmpty()) {
//             int num = pq.poll()[1];
//             ans.add(num);
//         }
//         Collections.sort(ans);
//         return ans;
//     }
// }

// Two Pointers O(n - k) + O(k) time , O(1) space
// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         List<Integer> ans = new ArrayList<>();

//         int left = 0;
//         int right = arr.length-1;

//         while (right - left >= k) {
//             int distL = Math.abs(x - arr[left]);
//             int distR = Math.abs(x - arr[right]);

//             if (distL > distR) {
//                 left++;
//             }
//             else {
//                 right--;
//             }
//         }

//         for (int i = left; i <= right; i++) {
//             ans.add(arr[i]);
//         }
//         return ans;
//     }
// }

// Binary Search optimal O(log (n-k)) + O(k) time, O(1) space
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right-left) / 2;

            int distStart = x - arr[mid];
            int distEnd = arr[mid + k] - x;

            if (distStart > distEnd) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        for (int i = left; i < left + k; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}