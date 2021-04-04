//TC: logn+k logn for binary search and k for the nearest value.
//SC: COnstant space..
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> output = new ArrayList<>();
        if(arr.length==0 || arr==null)
            return output;
        int index = binarySearch(arr, x);	//Using binarySearch finding the nearest less or eaual value of the target.
        output.add(arr[index]);			//Upon finding the nearest number, traversing either ways of the index to find k nearest values.
        k--;
        int lIndex = index-1;			//If the value is found at lower side add at 0 index, if found on higher side add at last.
        int rIndex = index+1;			//After finding the k values, add and return the list.
        while(k!=0)
        {
            if(lIndex<0)
            {
                output.add(arr[rIndex]);
                rIndex++;
            }
            
            else if(rIndex==arr.length)
            {
                output.add(0,arr[lIndex]);
                lIndex--;
            }
                
            else
            { 
                if(x-arr[lIndex]<=arr[rIndex]-x)
                {
                    output.add(0,arr[lIndex]);
                    lIndex--;
                }
                else
                {
                    output.add(arr[rIndex]);
                    rIndex++;
                }
            }
            k--;
        }
        return output;
    }
    
    int binarySearch(int[] arr, int x)
    {
        int l = 0, r = arr.length-1;
        while(l<r)
        {
            int mid = l+(r-l)/2;
            if(arr[mid]==x) return mid;
            else if(arr[mid]<x)
                l = mid+1;
            else
                r = mid;
        }
        if(l==0)
            return l;
        if(Math.abs(arr[l]-x)<Math.abs(arr[l-1]-x)) return l;
        return l-1;
    }
}