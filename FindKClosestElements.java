//idea: first find the index of target element using binary search then use two pointers first pointer is at index of target and second pointer is at next element.
//check difference between array element and target for two pointers. whichever difference is less  got towards that pointer.
//repeat the process till k closes element. return all element between two pointers.

//tc:klog n
//sc:o(k)
package binarysearch2;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //find the cloest element, r is the index of the cloest element
        int l = 0, r = arr.length-1;
        while(l < r) {
            int mid = (l + r)/2;
            if(arr[mid] == x) {r = mid; break;}
            else if(arr[mid] > x) r = mid-1;
            else l = mid+1;
        }
        
        //ensure the range
        l = r;
        r++;
        while(k>0) {
            if( r >= arr.length || (l >= 0 && x-arr[l] <= arr[r] - x) ) {
                l--;
            } else {
                r++;
            }
            
            k--;
        }
        
        List<Integer> list =new ArrayList<>();
        for(int i = l+1; i < r; i++) {
            list.add(arr[i]);
        }
        return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
