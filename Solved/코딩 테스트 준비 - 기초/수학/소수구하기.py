x, y = map(int, input().split())
num_by = int(y ** 0.5)
remove_arr = [1] * (y + 1)
remove_arr[1] = 0

for i in range(2, num_by + 1) :
  if (remove_arr[i] == 0) :
    continue
  j = 1
  while(i * j <= y) :
    if (x <= i * j <= y and j > 1) :
      remove_arr[i * j] = 0
    j += 1

for i in range(x, y + 1) :
  if (remove_arr[i] != 0) :
    print(i)