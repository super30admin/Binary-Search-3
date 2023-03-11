import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Find K Closest Elements
approach: 2 pointers or binary search
binary search: try finding the potential start point of result array using binary search;
 */
public class Problem2 {

    //time: O(n+k) space: O(1)
    public List<Integer> findClosestElementsTwoPointers(int[] arr, int k, int x) {
        int p1 = 0, p2 = arr.length-1;

        while(p2-p1>k-1) {
            int a = Math.abs(x-arr[p1]);
            int b = Math.abs(x-arr[p2]);

            if(a==b || a<b) {
                p2--;
            }
            else if(a>b){
                p1++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=p1;i<=p2;i++) res.add(arr[i]);
        return res;
    }

    //time: O(log n-k) space: O(1)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, h = arr.length-k;

        while(l<h) {
            int m = l+(h-l)/2;

            int distS = x-arr[m];
            int distE = arr[m+k]-x;

            if(distS>distE) {
                l = m+1;
            }
            else {
                h = m;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=l;i<l+k;i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        problem2.findClosestElements(new int[]{1,2,6,9,11,15,17,19,20}, 4, 14);
    }
}
