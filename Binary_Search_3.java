//1.Power(x,n)
//Time complexity -> O(logn)
//Space Complexity - > O(logn) //recursive stack
//Recursion

class Solution {
    //Using recursion
    public double myPow(double x, int n) {
        //base case
        if(n == 0) return 1.0;

        //logic
        double result = myPow(x, n/2);
        if(n%2 == 0){ //if n is even we do result*result
            return result*result;
        }else{
                if(n<0){
                    return result*result*(1/x);
                }else{
                    return result*result*x;
                }
            }
    }
}

//2nd Find K closest element
//Time Complexity - > O(nlogk)
//Space Complexity -> O(k) -> space for priorityQueue
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Here we are making PriorityQueue of type Integer meaning element of queue will be a array
        //Same as when we make PrioirityQueue of integer type all elements are of Integer
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
            if(a[0]==b[0]){
                return b[1] -a[1];
            }
            //where 0th index is distance for element of k and 1st index is element of array
            return b[0] - a[0];
        });

        for(int i=0;i<arr.length;i++){
            int dis = Math.abs(arr[i]-x);
            int[] p = new int[]{dis,arr[i]}; //Here we are making a array with 2 elements of dis as 0th index 
            // and 1st index as element itself
            pq.add(p);
            if(pq.size()>k){
                pq.poll();
            }           
        }

         List<Integer> result = new ArrayList<>();
            while(!pq.isEmpty()){
                int[] pair = pq.poll();
                result.add(pair[1]);
            }
            Collections.sort(result);
            return result;
        
    }
}