Problem-1: Pow xn
TC=O(logn)
class Solution {
    public double myPow(double x, int n) {
        
        //base
        if( n == 0) return 1;
        
        double temp = myPow(x, n/2);
        if(n % 2 == 0){ // when the power to the number is even
            return temp*temp;
        }else{
            if( n < 0){ // case when power is negative
                return (temp * temp) * 1/x;
            }else{
                return (temp * temp) * x; // pwer is +ve and n is odd
            }
        }
        
    }
}
Problem-2: K-closest elements
/**
Two pointer solution. Where, initially, left is starting of the arr and right is the end of the arr. Increase the left pointer if its distance to the target greater than the distance of the elmeent to the right. Process continues until distance of indexes between r and l pointer is greater than k.
TC = O(n-k)
Sc = O(1)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int low=0, high = arr.length-1;
        
        while(high - low +1 > k){
            
            int distL = Math.abs(x - arr[low]);
            int distH = Math.abs(x - arr[high]);
            
            if(distL > distH) low++;
            else high--;
        }
        
        List<Integer> result = new ArrayList<>();
        for( int i=low; i< low+k; i++){
            result.add(arr[i]);
        }
        
        return result;
        
        
    }
}
