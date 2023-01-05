// merge sort
//Time Complexity: O(nlog k)
//Space Complexity: O(n)

/*
 * maintain a hashmap with index and difference along with a max heap of 
 * distances. at the end just remove the elements from the heap and add
 * sorted list it to the result.
 */

class Solution {
    HashMap<Integer, Integer> map;
    List<Integer> result;    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        map = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int dis = Math.abs(arr[i] - x);
            map.put(i, dis);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            int valA = map.get(a);
            int valB = map.get(b);
            if(valA == valB){
                return b - a;
            }
            else{
                return valB-valA;
            }
        });
        result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }        
        while(!pq.isEmpty()){
            int idx = pq.poll();
            result.add(arr[idx]);
        }
        Collections.sort(result);
        return result;
    }
}

//binary sort
//Time Complexity: O(log(n-k))
//Space Complexity: O(1)

/*
 * we are looking for the start of the index and we perform a binary search
 * if the start is at mid then caluculate the range and it should be equi distant
 * from the the start and end so we move accordingly.
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int low = 0;
        int high = n-k;
        while(low < high){
            int mid = low + (high-low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid+k] - x;

            if(distS > distE){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = low; i < low+k; i++){
            result.add(arr[i]);
        }

        return result;
    }
}