def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
    #Time Complexity: O(logN)
    #Space Complexity: O(1)
    left = 0
    right = len(arr)-k
    while left<right:
        mid = left+(right-left)//2
        LB = abs(x-arr[mid])
        RB = abs(x-arr[mid+k])
        if LB>RB:
            left=mid+1
        else:
            if arr[mid]==arr[mid+k]:
                left=mid+1
            else:
                right=mid
    return arr[left:left+k]