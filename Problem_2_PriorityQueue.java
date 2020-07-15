// Time complexity - O(nlogk)
// Space complexity - O(k)

// PriortiyQueue Solution

class Solution {
    class Pair{
        int diff;
        int item;
        public Pair(int diff, int item){
            this.diff = diff;
            this.item = item;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.diff == b.diff){
                return b.item-a.item;
            }else{
                return b.diff-a.diff;
            }
        });
        List<Integer> result = new ArrayList<>();
        for(int a : arr){
            pq.add(new Pair(Math.abs(x-a), a));
            if(pq.size() > k){
                pq.poll();
            }
        }
       
       while(!pq.isEmpty()){
           Pair p = pq.poll();
           result.add(p.item);
       }
        Collections.sort(result);
        return result;
    }
}
