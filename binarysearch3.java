//Time log(n) and space log(n)
class Solution {
    double res=1;
    public double myPow(double x, int n) {
        //base case
        if(n==0) return 1;


        //logic
            double res = myPow(x,n/2);
            if(n%2==0){
                return res * res;

            }else{
                if(n<0){
                    return res * res * 1/x;
                }else{
                    return res * res * x;
                }
                
            }
        
    }
}

//Find k closest time O(nlogn + klogk) ans space O(n)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            int disA = Math.abs(x-a);
            int disB = Math.abs(x-b);
            if(disA==disB){
                return b-a;
            }
            return disB-disA;
    });

        for(int el:arr){
            pq.add(el);
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
        
    }
}
