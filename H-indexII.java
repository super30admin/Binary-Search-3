      
//Time complexity - O(N)      
//Space complexity - O(1)
//Microsoft
//The approach here is to keep seraching for the sub-array with no more than h citation each, 
//as we do       your normal if'h' citation to n paper at least 'n citations then n-h have no more than
// 'h' actions each max is taken as answer.I can go in linear manner their citations must not exceeds '3'
//neighbors which will have citation
class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int n= citations.length;
        for(int i = 0;i<n;i++){
            if(citations[i]>=n-i){
                return n-i;
            }
        }
        return 0;
    }
}