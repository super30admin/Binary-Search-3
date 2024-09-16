// Time Complexity : O( n) 
// Space Complexity : O(k) elements in recursive result if we consider result. or O(1) if we don't consider result.

// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//  

//Runtime: 4 ms, faster than 67.36% of Java online submissions for Find K Closest Elements.
//Memory Usage: 41.7 MB, less than 35.56% of Java online submissions for Find K Closest Elements.
 public List<Integer> findClosestElements(int[] arr, int k, int x) {
         int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
    }
	
	
	///***********The log n solution is not working
	
	 public List<Integer> findClosestElements(int[] arr, int k, int x) {//this is not working, it worked but new test cases added to leet code broke it.
             int l=0;
        int h= arr.length-k;
        
        while (l<h){
            int mid=l + (h-l)/2;
            
            int lBound= Math.abs(x - arr[mid]);
            int rBound= Math.abs(x - arr[mid+k]);
            
            if (lBound>rBound){
              l=mid+1;  
            }else{
               h=mid; 
            }     
        }
        List<Integer> resp= new ArrayList<>();
        for (int i=l;i<l+k;i++)
            resp.add(arr[i]);
        return resp;
    }