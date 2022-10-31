class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        
        int l=0;
        int h=arr.length-k;
        
        while(l<h)
        {
            int m=l+(h-l)/2;
            
            int d1=x-arr[m];
            int d2=arr[m+k]-x;
            
            System.out.println(d1+" "+d2);
            if(d1>d2)
            {
                l=m+1;
            }
            else
                h=m;
                
        }
        
        List<Integer> result=new ArrayList<>();
        for(int i=l;i<l+k;i++)
        {
            result.add(arr[i]);
        }
        
        return result;
        
        
    }
}

// Time Complexity : O( )
// Space Complexity : O( )
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
