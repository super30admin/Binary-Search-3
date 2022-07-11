// Time Complexity : O(log(n-k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//658. Find K Closest Elements
//https://leetcode.com/problems/find-k-closest-elements/


class Solution {
    //approach 3 MODIFIED BINARY SEARCH
    //time: O(log(n-k))
    //space:O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-k;
        int distStart;
        int distEnd;
        
        while(low<high){
            int mid = low + (high-low)/2;
            
            distStart = x-arr[mid];
            distEnd = arr[mid+k]-x;
            if(distStart > distEnd)
                low = mid +1;
            else
                high = mid;
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }
        return result;
        
    }
}


/*
class Solution {
    //approach 2 TWO POINTER
    //time: O(n-k)
    //space:O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int p1 = 0;
        int p2 = n-1;
        while(Math.abs(p1-p2)>=k){
            if(Math.abs(x-arr[p1]) > Math.abs(x-arr[p2])){
                p1++;
            }else{
                p2--;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = p1; i <= p2; i++){
            result.add(arr[i]);
        }
        return result;
    }
}
*/

/*
class Solution {
    //approach 1 BRUTE FORCE (ALMOST) MAX HEAP PQ
    //time: nlogn
    //space:O(k) - pq space - ask Lalwani if pair space needs to be considered
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //focus on getting the start and end index of K closest elements
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
                      if(a[0] == b[0])
                          return b[1] - a[1];
                      
                      return  b[0] - a[0];}); //Initializing pq to implement max heap
        
        for(int n : arr){
            pq.add(new int[]{Math.abs(n-x),n});
            if(pq.size() > k){ //To find k smallest distances using max heap appraoch
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){ //Get result
            int [] res = pq.poll();
            result.add(res[1]);
        }
        
        Collections.sort(result);
        return result;
        
    }
}
*/
