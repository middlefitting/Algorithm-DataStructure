# TimeComplex: O(N**0.5)
import math

def isPrimeNumber2(n):
  for i in range(2,int(math.sqrt(n))+1):
    if n % i == 0:
      return False
  return True

print(isPrimeNumber2(5))