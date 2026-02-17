import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Time Complexity : O(m log m + n log n) - sorting +O(max(m, n)) - where m and n are the lengths of the input arrays
Space Complexity : O(1)
Approach :
Sort the two arrays. Take two pointers, one at the start of each array. If the values are equal, add them to result and move both
pointers, else move the one that has less value. 
*/
public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> temp = new ArrayList<>();

        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1==0 || len2 ==0) return new int[0];

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0, j=0;
        while(i < len1 && j < len2){
            if(nums1[i] == nums2[j]){
                temp.add(nums1[i]);
                i++;
                j++;
            }else{
                if(nums1[i] < nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }

        }

        int [] result = new int[temp.size()];
        for(int k = 0;k < result.length; k++){
            result[k] = temp.get(k);
        }

        return result;
    }
}
