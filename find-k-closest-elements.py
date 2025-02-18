# tc O(n), sc O(1).

# find index of x
def get_xidx():
    start, end = 0, len(arr) - 1
    while start <= end:
        mid = start + ((end - start) // 2)
        if arr[mid] == x:
            return mid-1, mid+1, 1
        elif x < arr[mid]:
            end = mid - 1
        else:
            start = mid + 1
    return end, start, 0

i, j, cnt = get_xidx()
while cnt != k:
    if i < 0:
        diffi = float('inf')
    else:
        diffi = abs(arr[i]-x)
    if j == len(arr):
        diffj = float('inf')
    else:
        diffj = abs(arr[j]-x)
    
    if diffi <= diffj:
        i -= 1
    else:
        j += 1
    cnt += 1

return arr[i+1:j]