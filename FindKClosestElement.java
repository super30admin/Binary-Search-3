import java.util.ArrayList;
import java.util.List;

//2 pointer
/*
class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int n=arr.length;
      int l=0;
      int r=n-1;
      while(r-l>=k){
          int distl=Math.abs(x-arr[l]);
          int distr=Math.abs(x-arr[r]);
          if(distl>distr){
              l++;
          }else{
              r--;
          }
      }
      List<Integer> res=new ArrayList<>();
      for(int i=l;i<=r;i++){
          res.add(arr[i]);
      }
      return res;
  }
}
*/

//Heap solution
/*
class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int n=arr.length;
      PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
          int dista=Math.abs(x-a);
          int distb=Math.abs(x-b);
          if(dista==distb){
              return b-a;
          }else{
              return distb-dista;
          }
      });
      for(int i=0;i<n;i++){
          pq.add(arr[i]);
          if(pq.size()>k){
              pq.poll();
          }
      }
      List<Integer> res=new ArrayList<>();
      while(!pq.isEmpty()){
          res.add(pq.poll());
      }
      Collections.sort(res);
      return res;
  }
}
*/


//TC:O(log(n-k))
//SC:O(1)
//Binary Search
class FindKClosestElement {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
      int n=arr.length;
      int l=0;
      int h=n-k;
      while(l<h){
          int m=l+(h-l)/2;
          int dists=x-arr[m];
          int diste=arr[m+k]-x;
          if(dists>diste){
              l=m+1;
          }else{
              h=m;
          }
      }

      List<Integer> res=new ArrayList<>();
      for(int i=l;i<l+k;i++){
          res.add(arr[i]);
      }
      return res;
  }
}