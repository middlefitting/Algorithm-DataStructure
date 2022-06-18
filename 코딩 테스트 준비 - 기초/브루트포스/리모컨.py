# def find_close(num, arr) :
#   answer = 0
#   up = 1
#   while(num > 0) :
#     temp = num % 10
#     while (arr[temp] == 0) :
#       upside = 0
#       downside = 0
#       while (temp + upside < 10) :
#         if (arr[temp + upside] == 0) :
#           upside += 1
#         else :
#           break
#       while (temp - downside >= 0) :
#         if (arr[temp - downside] == 0) :
#           downside += 1
#         else :
#           break
#       if (downside < upside) :
#         temp = temp - downside
#       else :
#         temp = temp + upside
#     print(temp)
#     answer += up * temp
#     up *= 10
#     num = num // 10
#   return (answer)

def find_close2(num, arr) :
  answer = -500001
  temp = 0
  for i in range(num * 2 + 10) : 
    temp = i
    if (abs(num - temp) + len(str(temp)) < abs(num - answer) + len(str(answer))) :
      posible = 1
      for i in range (len(str(temp))) :
        if (arr[int(str(temp)[i])] == 0) :
          posible = 0
          break
      if (posible) :
        answer = temp
  return (answer)

N = int(input())
T = int(input())
if (T > 0) :
  disable = list(map(int, input().split()))
arr = [1] * 10
answer = 0
for i in range(T) :
  arr[disable[i]] = 0
answer =abs(N - 100)
result = find_close2(N, arr)
if (result >= 0) :
  result = abs(N - result) + len(str(result))
  answer = min(answer, result)
print(answer)