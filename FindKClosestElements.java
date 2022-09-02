// Time Complexity : O(log(n-k)) + O(k) where n = number of elements, k = k closest elements
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//658. Find K Closest Elements (Medium) - https://leetcode.com/problems/find-k-closest-elements/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    	//Time Complexity : O(n-k) where n = number of elements, k = number of closest elements
    	// Space Complexity : O(1)
//        List<Integer> result = new ArrayList<>();
//        int start = 0, end = arr.length-1;
//        
//        while (end - start + 1 != k) {
//            int sDist = Math.abs(x - arr[start]);
//            int eDist = Math.abs(arr[end] - x);
//            
//            if (sDist > eDist) {
//                start++;
//            } else {
//                end--;
//            }
//        }
//        
//        for (int i = start; i <= end; i++) {
//            result.add(arr[i]);
//        }
//        
//        return result;
    	
    	//Time Complexity : O(nlogk) + O(klogk) where n = number of elements, k = number of closest elements
    	// Space Complexity : O(n) where n = number of elements
//        List<Integer> result = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        
//        for (int i = 0; i < arr.length; i++) {
//            map.put(Math.abs(x - arr[i]), i);
//        }
//        
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> { // O(nlogk)
//            if (map.get(b).equals(map.get(a))) {
//                return b - a;
//            } else {
//                return map.get(b) - map.get(a);
//            }
//        });
//        
//        for (int i = 0; i < arr.length; i++) {
//            pq.add(i);
//            
//            if (pq.size() > k) {
//                pq.poll();
//            }
//        }
//        
//        while (!pq.isEmpty()) {
//            result.add(arr[pq.poll()]);
//        }
//        
//        Collections.sort(result); // O(klogk)
//        
//        return result;
        
        int start = 0, end = arr.length-k;
        
        while (start < end) { // O(log(n-k))
            int mid = start + (end-start)/2;
            int sDiff = x - arr[mid];
            int eDiff = arr[mid+k] - x;
            
            if (sDiff > eDiff) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = start; i < start+k; i++) { // O(k)
            result.add(arr[i]);
        }
        
        return result;
    }
}