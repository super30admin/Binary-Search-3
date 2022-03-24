class Solution {
 public class Pair{
    int diff;
    int val;
    
    public Pair(int diff, int val){
        this.diff = diff;
        this.val = val;
    }
}
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>(){
           public int compare(Pair o1, Pair o2){
               if(o1.diff!=o2.diff)
                    return o1.diff - o2.diff;
               else
                   return o1.val-o2.val;
           } 
        });
        
        for(int i=0; i<arr.length; i++){           
            minHeap.add(new Pair(Math.abs(arr[i]-x), arr[i]));
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<k && !minHeap.isEmpty(); i++){
            result.add(minHeap.poll().val);
        }
        Collections.sort(result);
        return result;
    }
}
