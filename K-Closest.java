// Time Complexity : O(n-k)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if(arr == null || arr.length == 0) return new ArrayList<>();
    
    //2 pointer solution
    int left = 0;
    int right = arr.length-1;
    
    // iterating until we find the k numbers
    while(right - left + 1 > k){
        int distLeft = x - arr[left]; // calculating left distance 
        int distRight = arr[right] - x;// calculating right distance
        if(distLeft > distRight){ // if left distance is more than right, then move left pointer ahead
            left++;
        }else{ //otherwise move right pointer left side
            right--;
        }
    }
    
    List<Integer> result = new ArrayList<Integer>();
    for(int i=left;i < left + k;i++){
        result.add(arr[i]);
    }
    
    return result;
}

binary search solution
// Time Complexity : O(log(n-k) + O(k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
public List<Integer> findClosestElements(int[] arr, int k, int x) {
    if(arr == null || arr.length == 0) return new ArrayList<>();
    
    //binary search algorithm
    int low=0;
    int high = arr.length-k;
    
    //searching for the first index for locating k elements
    while(low < high){
        int mid = low + (high-low)/2;
        int distLeft = x - arr[mid]; // searching for first element
        int distRight = arr[mid+k]-x; // searching for last element. it can be greater than high
        
        if(distLeft>distRight){
            low=mid+1;
        }else{
            high=mid;
        }
    }
    
    List<Integer> result = new ArrayList<Integer>();
    for(int i=low;i < low+k;i++){
        result.add(arr[i]);
    }
    
    return result;
}