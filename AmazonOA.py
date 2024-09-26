
def amazon(a,b,target):
    a.sort(key=lambda x: x[1])
    def BSearch(arr,target):
        low = 0
        high = len(arr) - 1
        while low < high:
            mid = (low + high) // 2

            if arr[mid][1] == target:
                return mid
            elif arr[mid][1] < target:
                low = mid 
            else:
                high = mid - 1
        return high
    diff = float('inf')
    output = []
    for i in range(len(b)):
        index = BSearch(a,target-b[i][1])
        if target - a[index][1] - b[i][1] == diff:
            output.append([a[index][0], b[i][0]])
        elif 0 <= target - a[index][1] - b[i][1] < diff:
            diff = target - a[index][1] - b[i][1]
            output = [[a[index][0], b[i][0]]]
    return output

    




a = [[1, 2], [2, 4], [3, 6]]
b = [[1, 2]]
target = 7
print(amazon(a,b,target))
