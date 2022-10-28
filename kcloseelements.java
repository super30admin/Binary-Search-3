// T.C- O(log(n-k)+k)
//S.C- O(1)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr==null || arr.length==0|| k==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> result= new ArrayList<>();
        int n= arr.length;
        int low= 0;
        int high= n-k;
        while(low<high){
            int mid= low+(high-low)/2;
            int start= x-arr[mid];
            int end= arr[mid+k]-x;
            if(start> end){
                low= mid+1;
            }else{
                high=mid;
            }
            
        }
        for(int i=low; i< low+ k;i++){
            result.add(arr[i]);
        }
        
        
        return result;
    }
    
}