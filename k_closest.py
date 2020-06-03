#Problem 2: Find K closest elements
#Time complexity: O(nlogk)
#Space complexity: O(n)
'''
we could substract each element by x and take the abs value. Then we find the
k smallest wit heap. That would be a O(nlogk). creating the differences array, 
the heap etc, are all O(n).
'''


class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr or k==0:
            return []
        differences=[(abs(num-x),i) for i,num in enumerate(arr)]
        return sorted([arr[x[1]] for x in heapq.nsmallest(k,differences)])


'''
Can we do better? we haven't used the fact that it's sorted. let's visualize
the difference array.We notice one thing, only the closest element to the targest
is a pivot (in the difference array). Since it it's not the closest, then the element 
on the left is closer or right is closer (if it's smaller than target, then going left 
will make the difference bigger,if going right doesn't make the difference smaller , 
it means that the right number is bigger than target, or else the difference would've been smaller. 
That means that any elements to the right after that will also be bigger, since the difference will only grow).
So we just need to find the pivot to get the closest element. We can do binary search, while always going
to the side with smallest difference. Once we've found the best element, we know that the k best elements
can't be more then k elements to the left or right, because surely the closer it is to x, the smaller
the difference is (sorted). So we can restrict the interval. Then by using a 2 pointer scheme,
we can derease the interval left or right depending on the difference, until or interval is
of length k. Also, If the first number is bigger then x, we take the first k numbers. if
last number is smaller then k, we take the last k numbers. Also to check it's pivot, we
need to iterate to the first element that is not the same to from the right or left, to 
make sure we don't get duplicates
'''
#Time complexity: O(logn)+O(k)
#Space: O(k), the array around pivot
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        #edge cases
        if not arr or k==0:
            return []
        if x<arr[0]:
            return arr[:k]
        if x>arr[-1]:
            return arr[len(arr)-k:]
            
        
        #searching the pivot
        high=len(arr)-1
        low=0
        found=False
        while high>=low:
            mid=low+(high-low)//2
    
            right,left=mid,mid
            while right!=len(arr)-1 and arr[mid]==arr[right]:
                right+=1
            while left!=0 and arr[mid]==arr[left]:
                left-=1
            if abs(arr[mid]-x)<= abs(arr[left]-x) and abs(arr[mid]-x)<= abs(arr[right]-x):
                pivot,found=mid,True
                break
            elif abs(arr[mid]-x)<= abs(arr[left]-x):
                low=mid+1
            else:
                high=mid-1
        if not found: pivot=high

        
        #finding k largest
        left=max(0,pivot-k)
        right=min(len(arr)-1,pivot+k)
        while right-left>=k:
            if abs(arr[right]-x)>=abs(arr[left]-x):
                right-=1
            else:
                left+=1
        return [arr[i] for i in range(left,right+1)]
