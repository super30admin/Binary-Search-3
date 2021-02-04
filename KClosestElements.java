class Solution {
    List<Integer> res;
    int i=0,j=0;
    int nearest;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        nearest = (arr.length)/2;
        res = new ArrayList<>();
        int count=0;
        
        if(arr[0]>=x){
            int i=0;
            while(i<k){
                res.add(arr[i++]);
            }
            return res;
        }
        
        else if(arr[arr.length-1]<=x){
            int i=0;
            while(k>0){
                res.add(arr[arr.length-k--]);
            }
            return res;
        }
        
        else{
            i = binarySearch(arr, x, 0, arr.length-1);
            j = i+1;
            
            while(i>=0 && i<arr.length-1 && j>0 && j<arr.length && count<k){
                int a = arr[i];
                int b = arr[j];
                if(Math.abs(a-x) < Math.abs(b-x)){
                    i--;
                }
                else if(Math.abs(a-x) == Math.abs(b-x)){
                    if(a<b){
                        i--;
                    }
                    else{
                        j++;
                    }
                }
                else{
                    j++;
                }
                count++;
            }
  
            while(count<k){
                count++;
                if(i>=0){
                    i--;
                }
                else if(j<arr.length){
                    j++;
                }
            }
        }
     
        i++;
        for(int l=i;l<j;l++){
            res.add(arr[l]);
        }
        return res;
    }
    public int binarySearch(int[] arr, int x, int low, int high){
        int mid = (low+high)/2;
        if(arr[mid] == x){
            return mid;
        }
        if(mid == high){
            return nearest;
        }
        if(Math.abs(arr[nearest]-x) > Math.abs(arr[mid]-x))
            nearest = mid;
        else if(Math.abs(arr[nearest]-x)==Math.abs(arr[mid]-x) && mid<nearest)
            nearest = mid;
        if(arr[mid]<x){
            return binarySearch(arr, x, mid+1, high);
        }
        return binarySearch(arr, x, low, mid-1);
    }
    
}

//Time complexity : O(logN + k) logN for binary search
//Space complexity : O(k) where k is the number of closest elements to x
