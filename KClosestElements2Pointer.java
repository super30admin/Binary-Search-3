import java.util.ArrayList;
import java.util.List;

public class KClosestElements2Pointer {
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {
	        
	        List<Integer> result = new ArrayList<>();
	        if(arr==null || arr.length<1) return result;
	        
	        int leftp=0;
	        int rightp=arr.length-1;
	        
	            while(rightp-leftp+1>k){
	                int rightd=arr[rightp]-x;
	                int leftd=x-arr[leftp];
	            
	                if(leftd>rightd){
	                    leftp++;
	                }else{
	                    rightp--;
	                }
	            }
	           
	        for(int i=leftp;i<=rightp;i++){
	            result.add(arr[i]);
	        }
	        
	        return result;
	        
	    }
}
