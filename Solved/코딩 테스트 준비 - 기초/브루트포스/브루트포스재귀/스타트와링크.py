def countNumber() :
  startScore = 0
  linkScore = 0
  for i in (start) :
    for j in (start) :
      startScore += arr[i][j]
  for i in (link) :
    for j in (link) :
      linkScore += arr[i][j]
  score = abs(startScore - linkScore)
  if (first[0]) :
    answer[0] = score
    first[0] = 0
  elif (score < answer[0]) :
    answer[0] = score
      
def startAndLink(depth, temp) :
  if (depth == N / 2) :
    for i in range(N) :
      if ((i in start) == False) :
        link.append(i)
    countNumber()
    for i in range(N) :
      if ((i in link) == True) :
        link.remove(i)
    return
    
  for i in range(temp, N) :
    start.append(i)
    startAndLink(depth + 1, i + 1)
    start.remove(i)

start = []
link = []
arr = []
answer = [0]
first = [1]
N = int(input())
for i in range(N) :
  arr.append(list(map(int, input().split())))
startAndLink(0,0)
print(answer[0])
