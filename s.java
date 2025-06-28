class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue <Integer> pq = new PriorityQueue <> ((a,b)->{
            int distA = Math.abs(a-x);
            int distB = Math.abs(b-x);
            if(distA==distB){
                return b-a; //farthest is the largest
            }
            return distB-distA;
        });

        for ( int num : arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
         List<Integer> result = new ArrayList<>(pq);
         result.sort(null);//collections.sort(result);
         return result;

    }
}
//