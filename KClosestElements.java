// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use a sliding window of size K+1 to balance equi distance element in start and end
// move the window till the start of the window is found using BS
// take k elements from the start of window

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0; int mid;
        int high = n-k;

        while (low<high) {
            mid = low + (high-low)/2;
            // we are not taking abs 
            int distLS = x - arr[mid];
            int distRS = arr[mid+k] -x; // mid + k to make sure we are confident while sliding the window one side
            if(distLS<=distRS)
                high = mid;
            else
                low = mid+1;
        }

        List<Integer> result = new ArrayList();
        for(int i= low;i<low+k;i++)
            result.add(arr[i]);

        return result;
    }


    // 2P : O(n)
    // Start from outwards and move low and high pointers inwards depending on the distance of element from x
    public List<Integer> findClosestElementsON(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        List<Integer> result = new ArrayList();
        while(high - low +1 > k){
            int distL = Math.abs(arr[low]-x);
            int distR = Math.abs(arr[high]-x);

            if(distL > distR)
                low++;
            else
                high--;
        }

        for(int i= low;i<=high;i++)
            result.add(arr[i]);
        
        return result;
    }

    // Heap : O(n log k + k log k)
    // Add elements to a max heap based on its distance from x
    // remove top elements till the last k elements remain
    // sort the last 4 elements based on element value
    public List<Integer> findClosestElementsON2(int[] arr, int k, int x) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->{
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x); 
            if(distA == distB)
                return b-a;
            
            return distB - distA;
        });
        
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> result = new ArrayList();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }
        Collections.sort(result);
        return result;
    }
}