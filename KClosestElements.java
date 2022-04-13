import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(log(n-k) + k)
//Space Complexity : O(1)
public class KClosestElements {	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		/**Approach: Binary search based on range**/
		int low= 0;
        int high= arr.length-k;        
        while(low < high){ //O(log (n-k))
            int mid= low + (high-low)/2;
            
            int distL= x-arr[mid];
            int distR= arr[mid+k]-x;            
            if(distL > distR){
                low= mid+1;
            }else{
                high= mid;
            }
        }        
        List<Integer> res= new ArrayList<>();
        for(int i=low; i< low+k; i++){ //O(k)
            res.add(arr[i]);
        }
        return res;
    }	
	
	// Driver code to test above
	public static void main (String[] args) {
		KClosestElements ob = new KClosestElements();	
		int[] arr= {1,2,6,9,11,15,17,19,20};//{1,2,3,4,5};
		int k = 4;
		int x = 14;//3;
		System.out.println(k+" closest elements to "+x+" in given array are: "+ ob.findClosestElements(arr,k,x));
	}	
}
