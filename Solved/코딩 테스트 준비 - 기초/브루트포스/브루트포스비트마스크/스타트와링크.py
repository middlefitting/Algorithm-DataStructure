def defineAnwser(link) :
  startPoint = 0
  linkPoint = 0
  for i in (start) :
    for j in (start) :
      startPoint += arr[i][j]
  for i in (link) :
    for j in (link) :
      linkPoint += arr[i][j]
  temp = abs(linkPoint - startPoint)
  if(first[0]) :
    answer[0] = temp
    first[0] = 0
  elif(temp < answer[0]) :
    answer[0] = temp
  if(answer[0] == 0) :
    print(0)
    exit()

def startAndLink(depth, now) :
  if (depth == N / 2) :
    link = []
    for i in range(N) :
      if ((i in start) == False) :
        link.append(i)
    defineAnwser(link)
  for i in range(now, N) :
    start.append(i)
    startAndLink(depth + 1, i + 1)
    start.remove(i)

N = int(input())
arr = []
start = []
answer = [0]
first = [1]
for i in range(N) :
  arr.append(list(map(int, input().split())))
startAndLink(0, 0)
print(answer[0])