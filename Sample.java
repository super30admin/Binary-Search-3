// Time Complexity :log(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1.00;
        double result = myPow(x,n/2);
        if(n%2 == 0){//even
            return result * result;
        }else{//odd
            if(n > 0){
                return result * result * x;
            }else{
             return result * result * (1/x);   
            }
                
        }
          
    }
    
}
// Time Complexity :log(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length-1;
        while(right - left +1 > k){
            if(Math.abs(arr[left] - x) > Math.abs(arr[right] - x)){
                left++;
            }else{
                right--;
            } 
        }
        List<Integer> result = new ArrayList<>();
        for(int i = left;i <= right;i++){
            result.add(arr[i]);
        }
        return result;
    }
}
