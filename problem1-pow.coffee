#/**
# * @param {number} x
# * @param {number} n
# * @return {number}
# */
myPow = (x, n) ->
  return 1 if n is 0

  recurVal = myPow(x, Math.sign(n) * (Math.abs(n)//2))

  if n % 2 is 0
    return recurVal * recurVal
  else
    if n < 0
      return recurVal * recurVal * 1/x
    else
      return recurVal * recurVal * x

myPow(2, 10)
myPow(2, -2)
