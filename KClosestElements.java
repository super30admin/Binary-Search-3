//Space  O(k)
// Time O(nlogk)

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1])   // [value , distance]
                return b[0]-a[0];
           else
               return b[1]-a[1];
        });
        
        
        //[ value, distance from target  ]
        
      for(int i =0;i<arr.length;i++)
      {
          int[]curr = {arr[i], Math.abs(arr[i]-x)};  // array of size 2 containing value and distance
          
          pq.add(curr);
          
          if(pq.size()>k)
              pq.poll(); //remove maximum element
          
          
      }
        
        //at this point we have the k closest ones inside q
        
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
        {
            int[] curr= pq.poll();
            res.add(curr[0]);
        }
        
        Collections.sort(res);
        
        return res;
         
        
    }
}