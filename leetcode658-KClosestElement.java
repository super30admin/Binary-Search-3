//Approach
/*
Two pointers : 
1. Left pointer, right pointer
2. if X -arr[left] <= arr[right] - X; right--;
3. else left++;
4. run these loop in while until right-left+1 >k ; that means when we get equality here, that means we're in a range of K elements we wanted. 
return those new elements in the form of arraylist!

TC: O(n-k)
sc: O(1)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //base case
        if(arr == null || k ==0 ) return new ArrayList<>(){};
        
    
        //take two pointers left and right
        int left = 0;
        int right = arr.length -1;
        
        while(right -left +1 > k)
        {
            //check whose dstance is more and move that pointer
            if(arr[right] - x >= x - arr[left])
                right--;
            else
                left++;
        }
        
        List<Integer> result =  Arrays.stream(arr, left, right+1).boxed().collect(Collectors.toList());
        return result;
    }
}


/* approach -2 *Min heap solution
pq size is k
We're using Max heap
TC: O(N) + O(N log k) + O(k)+ K log k :(traversing+ heapify + Queue+ copy to array list+ and sort)
*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
     //Min Heap solution
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> { //0 num, 1 dist
            if(a[1] == b[1])
            {
                return b[0]-a[0];
            }else
                return b[1] - a[1];
        });
        
        //pq size is k!
        for(int n : arr)
        {
            int[] temp = new int[]{n, Math.abs(n - x)};
            pq.add(temp);
            
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
        {
            result.add(pq.poll()[0]);
        }
        Collections.sort(result);
        return result;
        
    }
}
