// Time Complexity : O(n * log k + klogk), klogk for sorting the result which can be ignored as  nlogk is bigger.
// Space Complexity : O(k), number of elements in heap
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : maintain a heap based on the distance from x and if equidistant take smaller number

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //max heap - add on the basis of difference, or if equal take smaller number
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(a - x);
            int distB = Math.abs(b - x);

            // if(distA < distB){
            //     return 1;
            // }
            // else if(distA > distB){
            //     return -1;
            // }
            // else{
            //     return b-a;
            // }
            // same thing as above
            if(distA == distB) return b-a;
            return distB - distA;
        });

        for(int a : arr){
            pq.add(a);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result);
        return result;
    }
}


// Two pointer Approach
// Time Complexity : O(n-k) + o(k) = O(n).
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english :Use two pointers to find range of k closest elements to x.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length -1;

        while(hi - lo >= k){
            int dlo = Math.abs(arr[lo] - x);
            int dhi = Math.abs(arr[hi] - x);

            if(dlo > dhi){
                lo++;
            }
            else{
                hi--;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = lo ; i <= hi ; i++){
            result.add(arr[i]);
        }

        return result;
    }
}

// binary search option to find range
// Time Complexity : O(log(N−k)+k)
// Space Complexity : O(1), 
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Search for range using BinarySearch.

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length -k;

        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            //In some edge cases (with a sequence of identical numbers), it will move the left bound to the correct direction. Hence not using absoulte value
            int start =  x - arr[mid];
            int end = arr[mid+k] -x;
            if(start > end){
                lo = mid+1;
            }
            else{
                hi = mid; 
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = lo ; i < lo +k ; i++){
            result.add(arr[i]);
        }

        return result;
    }
}