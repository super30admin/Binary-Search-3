class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> {
            if (b[1]==a[1]){
                return b[0]-a[0];
            }
            return b[1]-a[1];
            });

        for(int num:arr){
            int diff= Math.abs(num-x);
            pq.offer(new int[]{num, diff});
            while(pq.size()>k){
            pq.poll();
            }  
        }
        List<Integer> list= new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll()[0]);
        }
        Collections.sort(list);
        return list;
    }
}