// Time complexty - O(nlogn)
// Space complexity - O(n)

// Pair class for difference and array item, and custom sort function to sort List of Pair objects.

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
        List<Pair> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int a : arr){
            list.add(new Pair(Math.abs(x-a), a));
        }
       
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.diff == o2.diff){
                    return o1.item - o2.item;
                }else{
                    return o1.diff - o2.diff;
                }
            }
        });
         for(int i = 0;i < k; i++){
            result.add(list.get(i).item);
        }
        Collections.sort(result);
        return result;
    }
}
