T = int(input())

for t in range(T) :
  M, N, x, y = map(int, input().split())
  i = x
  answer = 0
  while(i <= M * N) :
    temp_x = i % M
    temp_y = i % N
    if (temp_x == 0) :
      temp_x = M
    if (temp_y == 0) :
      temp_y = N
    if (temp_x == x and temp_y == y) :
      answer = i
      break
    i += M

  if (answer > 0) :
    print(answer)
  else :
    print(-1)