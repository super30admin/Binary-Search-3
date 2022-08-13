      
//Time complexity - O(logN)      
//Space complexity - O(1)
//Microsoft
//The approach here is to keep seraching for the sub-array with no more than h citation each, as we do       your normal if'h' citation to n paper at least 'n citations then n-h have no more than 'h' actions each max is taken as answer.I can go in linear manner their citations must not exceeds '3' neighbors which will have citation
class Solution {
   public int hIndex(int[] citations) {
       int left=0, n=citations.length;
       int right=citations.length-1;
       while(left<=right){
           int mid=left+(right-left)/2;
           if(citations[mid]==n-mid){
               return n-mid;
           }
           else if(citations[mid]<n-mid){
               left=mid+1;
           }
           else{
               right=mid-1;
           }
       }
       return n-left;
   }
}