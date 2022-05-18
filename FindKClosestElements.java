import java.util.*;
public class FindKClosestElements {
    
    public static List<Integer> kClosest(int[] arr, int k, int x)
    {
        if(arr == null || arr.length == 0) return new ArrayList<>();

        int low = 0, high = arr.length-k;
        while(low < high)
        {
            int mid = low + (high - low)/2;
            int distS = x - arr[mid];
            int distE = arr[mid + k]- x;

            if(distS>distE)
            {
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = low; i<low+k;i++)
        {
            ans.add(arr[i]);
        }

        return ans;
    }


    public static void main(String args[])
    {
        int[] arr = {1,2,3,4,5};

        List<Integer> ans = kClosest(arr, 4, 3);
        for(int i : ans)
        {
            System.out.print(i+" ");
        }
    }
}
