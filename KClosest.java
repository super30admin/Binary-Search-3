/*
Approach 1: Best approach, finding the starting points of those k elements which we are looking for, as it is sorted array
then apply binary search on those n-k points 
TC: log(n-k)
SC: O(1)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k; //it can be the last starting point of those k elements which we are looking for
        while(low<high){
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;
            //we move towards the smaller distance
            if( distS > distE){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low +k ; i++){
            result.add(arr[i]);
        }
        return result;

    }
}

/*
Use maxheap to store k smallest elements always
Design PQ such that it sorts by differnece, if difference is same sort by smaller value
TC: O(nlogk)
SC: O(k)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(x-a);
            int distB = Math.abs(x-b);
            if(distA == distB){
                return b-a;
            }
            return distB - distA;
        });
        for(int a : arr){
            pq.add(a);
            if(pq.size()>k){
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