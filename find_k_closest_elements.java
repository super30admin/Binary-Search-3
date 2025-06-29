//Time Complexity: nlogk 

//Using maxHeap Solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int dista = Math.abs(x - a);
            int distb = Math.abs(b- x);
            //here, 
            //smaller index should remain down, bigger index should remain up so that it can be taken ou of the maxHeap
            //bigger distance should be up in maxHeap so that it can be taken out
            if(dista == distb){
                return b-a;
            }
            return distb - dista;
        });

        for(int i=0; i<arr.length; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
           result.add(pq.poll());
        }

        Collections.sort(result);
        return result;
    }

//Using Two Pointers Solution
//Time Complexity: O(n)
//Space Complexity: O(1)


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int high = arr.length -1;
        int low = 0;
        while((high - low) >= k){
            int distl = Math.abs(x - arr[low]);
            int disth = Math.abs(x - arr[high]);
            if(distl > disth){
                low++;
            }else{
                high--;
            }
        }
        for(int i= low; i<=high; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

//Using Binary Search
//Time Complexity: log(n-k) , finding range of start element
//Space Complexity:

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int high = arr.length -k;
        int low = 0;
        while(low < high){
            int mid = low +(high -low)/2;
            int dists = x - arr[mid];
            int diste = arr[mid+k] - x;
            if(dists > diste){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        for(int i= low; i<low+k; i++){
            result.add(arr[i]);
        }
        return result;
    }
}

