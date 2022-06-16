def find_close(num, arr) :
  answer = 0
  up = 1
  while(num > 0) :
    temp = num % 10
    while (arr[temp] == 0) :
      upside = 0
      downside = 0
      while (temp + upside < 10) :
        if (arr[temp + upside] == 0) :
          upside += 1
        else :
          break
      while (temp - downside >= 0) :
        if (arr[temp - downside] == 0) :
          downside += 1
        else :
          break
      if (downside < upside) :
        temp = temp - downside
      else :
        temp = temp + upside
    answer += up * temp
    up *= 10
    num = num // 10
  return (num)

N = int(input())
T = int(input())
arr = [1] * 10
answer = 0
for i in range(T) :
  arr[int(input())] = 0

if (98 <= N <= 102) :
  answer =abs(N - 100)

else :
  result = find_close(N, arr)
  print(abs(N - result) + len(str(N))