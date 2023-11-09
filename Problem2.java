//Time Complexity : O(n)
//Space Complexity: O(n)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]){
                return b[0]-a[0];
            }
            return b[1]-a[1];
        });
        
        for(int i=0; i<arr.length; i++){
            int dist = Math.abs(arr[i] - x);
            pq.add(new int[] {arr[i], dist});
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] popped=pq.poll();
            result.add(popped[0]);
        }
        Collections.sort(result);
        return result;
    }
}
