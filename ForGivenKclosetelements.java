//2 pointer solution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)  return result;
       
        int low= 0; int high = arr.length -1; // except k elements
        while(high -low > k-1 ){   //O(n-k)
           int distL = Math.abs(x- arr[low]);
           int distR = Math.abs(x- arr[high]);    
           
            if(distL > distR){
                low++;
            }
            else{
                 high--;
            }
        }
       
        for(int i = low ; i < low+k ;i++){   //O(k)
            result.add(arr[i]);
        }
       
        return result;
    }
}

/*
TimeComplexity: O(n-k) + O(k) Aysmtotically it is O(n-k)
Space Complexity: O(1)
*/