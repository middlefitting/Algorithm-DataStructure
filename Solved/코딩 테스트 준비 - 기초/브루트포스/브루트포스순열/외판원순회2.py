def findAnswer(answer) :
  temp = 0
  for i in range(N - 1) :
    temp += cost[arr[i]][arr[i + 1]]
    if(cost[arr[i]][arr[i + 1]] == 0) :
      return (answer)
  temp += cost[arr[N - 1]][arr[0]]
  if(cost[arr[N - 1]][arr[0]] == 0) :
    return (answer)
  if (temp < answer) :
    answer = temp
  return (answer)

def sameArr() :
  for p in range(N) :
    if (maxArr[p] != arr[p]) :
      return (False)
  return (True)

N = int(input())
arr = []
for i in range(0, N) :
  arr.append(i)
cost = []
for i in range(N) :
  cost.append(list(map(int, input().split())))
maxArr = arr.copy()
maxArr.sort(reverse=True)
answer =  10000000
answer = findAnswer(answer)

while(True) :
  for i in range(1, N) :
    if (arr[N - i] > arr[N - i - 1]) :
      miniArr = arr[N - i:].copy()
      while(True) :
        mini = min(miniArr)
        if (mini > arr[N - i - 1]) :
          break
        else :
          miniArr.remove(mini)  
      
      temp = arr[N - i - 1:].copy()
      temp.remove(mini)
      temp.sort()
      for j in range(i) :
        arr[N - i + j] = temp[j]
      arr[N - i - 1] = mini
      answer = findAnswer(answer)
      break
    if (sameArr()) :
      print(answer)
      exit()
