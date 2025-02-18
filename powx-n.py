# tc O(log n), sc O(1).
oldn = n
n = abs(n)
res = 1

while n != 0:
    if n % 2 == 1:
        res *= x
        n -= 1
    
    x *= x
    n //= 2

if oldn < 0:
    return 1 / res
return res