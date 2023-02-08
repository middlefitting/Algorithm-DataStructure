def defineLogic(depth, i, j, now) :
  if (arr[depth][i] == '0' and now == 0) :
    return (True)
  if (arr[depth][i] == '-' and now < 0) :
    return (True)
  if (arr[depth][i] == '+' and now > 0) :
    return (True)
  return (False)
  
def findNumber(depth) :
  if (depth == -1) :
    for i in range (N) :
      print(answer[i], end = " ")
    print()
    exit()
  for j in range(-10, 11) :
    now = 0
    answer[depth] = j
    success = True
    for i in range(N - depth) :
      now += answer[depth + i]
      if(defineLogic(depth, i, j, now) == False) :
        success = False
    if (success) :
      findNumber(depth - 1)

N = int(input())
arr = []
answer = [0] * N
matrix = str(input())
temp = 0
for i in range(N) :
  tempArr = []
  for j in range(N - i) :
    tempArr.append(matrix[temp])
    temp += 1
  arr.append(tempArr)

findNumber(N - 1)