//Problem 1
//TC O(logn)
//SC O(logn)

class Solution {
    public double myPow(double x, int n) {
    if(n==0)
    {
        return 1.0;

    }
    double result=myPow(x,n/2);
    if(n%2==0)
    {
        return result*result;
    }
    else{
        if(n>0)
        {
            return result*result *x;
        }
        else{
            return result*result/x;
        }
    }
    }
}

//Problem 2
//TC O(logn)
//SC O(1)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int low=0;
//        int high=arr.length-k;
//        int mid;
//        while(low<high)
//        {
//         mid=low+(high-low)/2;
//         int dists=x-arr[mid];
//         int diste=arr[mid+k]-x;
//         if(dists>diste)
//         {
//             low=mid+1;
//         }
//         else{
//             high=mid;
//         }
//        } 
//        List<Integer> result=new ArrayList<>();
//        for(int i=low;i<low+k;i++)
//        {
// result.add(arr[i]);
//        }
//        return result;
// 2 pointer
int start=0;
int end=arr.length-1;
while(end-start+1>k)
{
    int dists=x-arr[start];
    int diste=arr[end]-x;
    if(dists>diste)
    {
        start++;
    }
    else{
        end--;
    }
}
List<Integer> result=new ArrayList<>();
for(int i=start;i<end+1;i++)
{
    result.add(arr[i]);
}
return result;
    }
}