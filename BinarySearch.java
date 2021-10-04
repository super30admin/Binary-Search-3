import java.util.*;

public class BinarySearch{
    //time complexity : log(n-k) + k
    //space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/find-k-closest-elements/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        while(low<high){
            int mid = low + ((high-low)/2);
            int sdist = x - arr[mid];
            int edist = arr[mid+k] -x;
            if(sdist <= edist){
                high = mid;
                
            }else{
                low = mid+1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i =low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
    //time complexity : log(n)
    //space complexity : n/2
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/powx-n/
    public double myPow(double x, int n) {
        if(n==0)return 1.00;
        double result =  myPow(x,n/2);
        if(n%2==0){
          return result*result;
        }else{
            if(n>0){
            return result*result*x;
            }else{
                return result*result*(1/x);
            }
          
        }
        
    }
}