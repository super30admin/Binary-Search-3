//658. Find K closest Elements - https://leetcode.com/problems/find-k-closest-elements/description/
//Time Complexity: log(n) + O(k) //binary search + find 'k' elements
//Space Complexity: O(1)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-k;

        while(low < high){
            int mid = low + (high - low)/2;

            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;

            if(distS > distE){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=low; i<low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}


//Time Complexity: n * log(k)
//Space Complexity: O(k)
//Heaps
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            //add first 'k' elements to Heap
            if (k > 0) {
                minHeap.add(num);
                k--;
                //compare root of Heap with next incoming num
            } else if (Math.abs(minHeap.peek() - x) > Math.abs(num - x)) {
                minHeap.poll(); //if greater, poll the root
                minHeap.add(num); //add the num to the heap
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}