def printArr() :
  for i in range(N) :
    print(arr[i], end = " ")
  print()

def sameArr() :
  for p in range(N) :
    if (maxArr[p] != arr[p]) :
      return (False)
  return (True)

N = int(input())
arr = []
for i in range(1, N + 1) :
  arr.append(i)
maxArr = arr.copy()
maxArr.sort(reverse=True)

printArr()

while(True) :
  if (N == 1) :
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
      printArr()
      break
    if (sameArr()) :
      exit()
