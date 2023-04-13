class Solution {
    //TC-O(nlogk)
    //SC-O(k)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // get the k closest elements from x based on their differeneces by placeing them in a heap
        // hashmap with numbers and their distances
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i< arr.length;i++){
            hm.put(i,Math.abs(arr[i] - x));
        }

        // create a priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
        int dista = hm.get(a);
        int distb = hm.get(b);
        if(dista == distb){
            // to give priority to lower index
            return b-a;
        }
        // we need max heap to get k closest elements
        return distb-dista;
        }
        )
        ;
        for(int i = 0 ;i <arr.length;i++){
            pq.add(i);
            if (pq.size()>k){
                pq.poll();
            }
        }
    while(!pq.isEmpty()){
        result.add(arr[pq.poll()]);
    }
    Collections.sort(result);
    return result;
    }
}