class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // create a max heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        
        // fill the max heap for size k only by polling
        for(int i=0;i<arr.length;i++){
            int dis = Math.abs(arr[i]-x);
            pq.add( new int [] {dis, arr[i]});
            if(pq.size() > k){
                pq.poll();
            }
        }
   
        // get the k elements into an array
        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            int [] popped = pq.poll();
            list.add(popped[1]);
        }

        // sort
        Collections.sort(list);

        return list;
    }
}