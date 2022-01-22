// Time Complexity: O(log(n-k)) + o(k) // find the index and then copy over k elements
// Space Complexit: O(1)
// moving high and low ptrs with window k
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        
        // start searching for the possible window of size k
        int low = 0, high = arr.length - k;
        // use binary search to find location start and end location of k close elements
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            // move high and low ptr based on whichever has higher distance
            int distLow =  x - arr[mid];
            int distHigh = arr[mid + k] - x; // mid + k since we want to know if last element at mid + k location is valid. valid means dist is less
            if(distLow > distHigh) // dist from high is more bring it closer
            {
                low = mid +1;
            }
            else
            {
                high = mid;
            }
        }
        
        // copy the values between low and high
        for(int i = low ; i < low+ k ; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}


// Time Complexity: O(n-k) + o(k) // find the index and then copy over k elements
// Space Complexit: O(1)
// moving high and low ptrs
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return result;
        
        int low = 0 , high = arr.length-1;
        
        // stop when your window is equal to k elements req
        while(high - low + 1 > k)
        {
            // move high and low ptr based on whichever has higher distance
            int distLow = Math.abs(x-arr[low]);
            int distHigh = Math.abs(x-arr[high]);
            if(distLow < distHigh) // dist from high is more bring it closer
            {
                high--;
            }
            else //(distLow > distHigh)
            {
                low++;
            }
        }
        
        // copy the values b/w low and high
        for(int i = low ; i <= high ; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}
