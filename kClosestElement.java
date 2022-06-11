//---------------HEAP Solution-----------------
// Time Complexity :O(n)+O(nlogk)
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
//here we are using max heap of size k and map of distances to eliminate all the larger distances and at the end we'll end 
//up with k smallest distances which we will return at the end
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], Math.abs(arr[i] - x));
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int distA = map.get(a);
            int distB = map.get(b);
            if (distA == distB) {
                return b - a;

            } else {
                return distB - distA;
            }

        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}

// --------------TWO POINTER-------------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// here we are using two pointers starting from start and end and shrinking the
// window to find range
// of k closest elements based on the distance with target/x
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length - 1;
        int left = 0;
        int right = n;
        while (right - left + 1 > k) {
            int distL = x - arr[left];
            int distR = arr[right] - x;
            if (distL > distR) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}

// --------BINARY SEARCH FIND RANGE-----------------------------
// Time Complexity :log(n-k)+kto add in result array
// Space Complexity :constanat
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we are trying to find range hence startOf the range by binary search we are
// trying to balance the distance
// and at the end low pointer gives us the start of our range
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        int low = 0;
        int high = n - k;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int startWDiff = x - arr[mid];
            int endDiff = arr[mid + k] - x;
            if (startWDiff > endDiff) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}