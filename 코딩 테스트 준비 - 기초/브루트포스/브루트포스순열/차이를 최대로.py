def findAnswer(answer) :
  temp = 0
  for i in range(N - 1) :
    temp += abs(arr[i] - arr[i + 1])
  if (temp > answer) :
    answer = temp
  return (answer)

def sameArr() :
  for p in range(N) :
    if (maxArr[p] != arr[p]) :
      return (False)
  return (True)

N = int(input())
arr = list(map(int, input().split()))
arr.sort()
maxArr = arr.copy()
maxArr.sort(reverse=True)
answer = 0
answer = findAnswer(answer)

while(True) :
  if (N == 1) :
    print(answer)
    exit()
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
