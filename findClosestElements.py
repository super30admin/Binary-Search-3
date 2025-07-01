# TimeComplexity:O(k+logN)
# Space:Constant
# Appraoch:
# BruteForce:Have distances array , pair with elements in arr and sort get first k elements
# TwoPointer:Have two pointer compress unitll len is equal to k 
#         abs1=abs(nums[l]-x)
#         abs2=abs(nums[h]-x)
# Sorted Always think of binary Search and 2 pointers
# BinarySearch:
#   instead of finding x lets find satrting of our ans with size k 
#   we compute mid this is starting point of our ans and mid+k(why not mid+k-1?)
#   arr[mid + k - 1] is the last element in the current window. we're not comparing elements inside the current window. we’re comparing edges of two neighboring windows:
#   Current window: arr[mid : mid + k]
#   Next window: arr[mid + 1 : mid + k + 1]

# So to decide whether to shift right, you look outside your current window at arr[mid + k]
#   we compare distances of both 
#            disL=x-arr[mid]
#            disH=arr[mid+k]-x
# based on that decison we move our low or high pointer 

class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #using binary serach to find starting point of range 
        #we are trying to find if mid is starting point of range
        # we compute mid ,and distance bwteen high pointer  and x and low pointer and x  we move towards less distance
        low,high=0,len(arr)-k
        ans=[]
        #bs
        while(low<high):
            mid=(low+high)//2
            disL=x-arr[mid]
            disH=arr[mid+k]-x
            if disL>disH:
                low=mid+1
            else:
                high =mid
        for i in range(low,low+k):
            ans.append(arr[i])
        return ans

class Solution:
    def findClosestElements(self, nums: List[int], k: int, x: int) -> List[int]:
        #use two pointers , compress unitll len==k
        l,h=0,len(nums)-1
        while(h-l+1!=k):
            abs1=abs(nums[l]-x)
            abs2=abs(nums[h]-x)
            if abs2>=abs1:
                h-=1
            else:
                l+=1
        ans=[]
        for i in range(l,h+1):
            ans.append(nums[i])
        return ans
