//****POWER X^N-BRUTEFORCE****
//Time complexity: o(n);
//Space complexity: o(1);
//Leetcode runnable: Y;
//Any doubts:N;
class Solution {
    public double myPow(double x, int n) {
        double result=1.000;
        //Positive
        if(n>0)
        {
           while(n!=0)
            {
                result*=x;
                n--;
            } 
        }
        if(n<0)
        {
            while(n!=0)
            {
                result*=1/x;
                n++;
            } 
            
        }
        
      return result ; 
    }
}
//****POWER X^N-OPTIMAL RECURCIVE WAY****
//Time complexity: o(logn);
//Space complexity: o(logn);
//Leetcode runnable: Y;
//Any doubts:N;


class Solution {
    public double myPow(double x, int n) {
        //Base
        if(n==0) return 1.000;
        //Logic
        double result= myPow(x,n/2);
        //Is even
        if(n%2==0)
        {
            return result*result;   
        }
        //is odd
        else
        {
            if(n<0)
            {
                return result*result*(1/x);
            }
            else
            {
                return result*result*x;  
            }
            
        } 
            
    }
}

//****FIND K-CLOSEST ELEMENTS- HEAP SOLUTION****
//Time complexity: o(nlogk);
//Space complexity:o(k);
//Leetcode runnable : Y;
//Any doubts:n;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Max heap
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
        if(a[1]==b[1])
        {
            return b[0]-a[0];
        }
            return b[1]-a[1];
        });
        
        List<Integer> result=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++)
        {
            pq.add(new int[]{arr[i],Math.abs(arr[i]-x)});
            if(pq.size()>k)
            {
                pq.poll();
            }
            
        }
        
        while(!pq.isEmpty())
        {
            int[] pair=pq.poll();
            result.add(pair[0]);
        }
        Collections.sort(result);
        return result;
    }
}


//****FIND K-CLOSEST ELEMENTS- TWO POINTERS SOLUTION****
//Time complexity: o(n-K);
//Space complexity:o(1);
//Leetcode runnable : Y;
//Any doubts:n;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-1;
        
        while(r-l+1>k)
        {
            int ldiff=Math.abs(arr[l]-x);
            int rdiff=Math.abs(arr[r]-x);
            
            if(ldiff>rdiff)
            {
                l++;
            }
            else
            {
                r--;
            }
            
            
        }
        List<Integer> result=new ArrayList<>();
        for(int i=l;i<=r;i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}
