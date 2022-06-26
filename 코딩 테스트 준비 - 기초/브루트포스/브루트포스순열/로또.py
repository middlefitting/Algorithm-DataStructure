from itertools import combinations

first = 0
while(True) :
  arr = list(map(int, input().split()))
  if (arr[0] == 0) :
    break
  arr = arr[1:]
  arr.sort()
  if(first != 0) :
    print()
  for now in combinations(arr, 6) :
    for j in range(6) :
      print(now[j], end = " ")
    print()
  first += 1
