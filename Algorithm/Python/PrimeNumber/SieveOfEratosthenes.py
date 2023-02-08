# TimeComplex: O(NloglogN)
# using many memory
import math

n = int(input())
array = [True for i in range (n+1)]

for i in range(2, int(math.sqrt(n)) + 1):
  if array[i] == True:
    j = 2
    while(j*i<=n):
      array[j*i] = False
      j += 1

for i in range(2,n+1):
  if(array[i] == True):
    print(i, end = " ")