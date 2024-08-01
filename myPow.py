def myPow(x,n):
    if n == 0:
        return 1
    if n < 0:
        x = 1 / x
        n = -n
    if n % 2 == 0:
        return myPow(x * x, n // 2)
    else:
        return x * myPow(x * x, n // 2)
    
x = 2
n= 5
print(myPow(x,n))

#time = O(logn)