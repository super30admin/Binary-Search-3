import java.util.*;
public class Problem3 {


    public static int binarySearch(int[][] array, int left, int right, int target) {
        
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;
        if (array[mid][1] == target) {
            return mid;
        } else if (array[mid][1] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return binarySearch(array, left, right, target);

    }

    public static List<int[]> optimizeRoute(int[][] a, int[][] b, int maxValue) {
        java.util.Arrays.sort(b, new java.util.Comparator<int[]>() {
            public int compare(int[] x, int[] y) {
                return Integer.compare(x[1], y[1]);
            }
        });
     
        List<int[]> out = new ArrayList<int[]>();
        int curr_max = 0;
        for (int i = 0; i < a.length; i++) {
            
            int target = maxValue - a[i][1];
            int index = binarySearch(b, 0, b.length - 1, target);
            int total = a[i][1] + b[index][1];
            if (total <= maxValue) {
                
                if (curr_max == total) {
                    out.add(new int[] {a[i][0], b[index][0]});
                }
                else if (curr_max < total) {
                    curr_max = total;
                    out = new ArrayList<int[]>();
                    out.add(new int[] {a[i][0], b[index][0]});
                }
            }
        }

        return out;

    }
    
    public static void main(String[] args) {
        int[][] a = new int[][] {{1, 3}, {2, 5}, {3, 8}, {4, 7}};
        int[][] b = new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}};

        List<int[]> out = optimizeRoute(a, b, 10);
        for (int i = 0; i < out.size(); i++) {
            System.out.println(out.get(i)[0] + " : " + out.get(i)[1]);
        }

    }

}
