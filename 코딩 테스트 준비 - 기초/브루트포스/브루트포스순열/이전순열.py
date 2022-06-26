N = int(input())
arr =list(map(int, input().split()))

answer = False
for i in range(1, N) :
  if (arr[N - i] < arr[N - i - 1]) :
    answer = True
    miniArr = arr[N - i:].copy()
    while(True) :
      mini = max(miniArr)
      if (mini < arr[N - i - 1]) :
        break
      else :
        miniArr.remove(mini)  
    
    temp = arr[N - i - 1:].copy()
    temp.remove(mini)
    temp.sort(reverse=True)
    for j in range (N - i -1) :
      print(arr[j], end = " ")
    print(mini, end = " ")
    for k in range (i) :
      print(temp[k], end = " ")
    print()
    break
if (answer == False) :
  print(-1)
