#Brute force solution to solve the problem
#Time Complexity: O(nlogn)
#Space complexity: O(2n)
arr = [1,2,3,4,5]
k = 4
x = 3
li = list()
li2 = list()
def findClose(arr,k,x):
    for i in range(len(arr)):
        li.append(((abs(arr[i]-x)),arr[i]))
    print(sorted(li))

    for i in range(k):
        li2.append(li[i][1])
    print(li2)
    return li2

l = findClose(arr,k,x)
print(l)