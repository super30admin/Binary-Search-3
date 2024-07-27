//time O(nlogk)
//space O(k)
//approach Build a PQ of size k and insert pair of index, distance from x and make the PQ a max-heap such if that two numbers are equidistant from x then choose the one with smaller index and discard the other. Similarly choose the one with smaller distant in other cases and add it to PQ. In the end poll the pairs from PQ and return in sorted list.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //find the closest element index
        int clo = 0;
        List<Integer> result = new ArrayList<>();
        if(x <= arr[0]) clo = 0;
        else if(x >= arr[arr.length-1]) clo = arr.length-1;
        else{
            int low = 0;
            int high = arr.length-1;
            //1 5 10
            //h l
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(arr[mid] == x) {
                    clo = mid;
                    break;
                }
                else if(arr[mid] < x) {
                    low = mid + 1;
                } else if(arr[mid] > x) {
                    high = mid -1;
                }
            }
            if(low > high) {
                clo = low;
            }        
        }
        int left = clo - 1;
        int right = clo;
        while (k > 0) {
            if (left < 0) {
                result.add(arr[right]);
                right++;
            } else if (right >= arr.length) {
                result.add(arr[left]);
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
            k--;
        }
        Collections.sort(result);
        return result;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        //store index, distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        
        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[] {i, Math.abs(arr[i] - x)});
            if(pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            result.add(arr[pair[0]]);
        }
        Collections.sort(result);
        return result;
    }
}
