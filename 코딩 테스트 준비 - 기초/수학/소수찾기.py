T = int(input())
arr = list(map(int, input().split()))
count = 0

for i in range(T) :
  n = 2
  if (arr[i] > 1) :
    count += 1
  num_by = int(arr[i] ** 0.5)  
  while (n <= num_by) :
    if (arr[i] % n == 0) :
      count -= 1
      break
    n += 1
print(count)