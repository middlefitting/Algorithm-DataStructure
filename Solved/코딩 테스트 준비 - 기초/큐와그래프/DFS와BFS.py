import sys

def dfs(pre) :  
  if(len(answer) == N) :
    return
  for i in (vector[pre]) :
    if ((i in answer) == 0) :
      answer.append(i)
      dfs(i)

def bfs(pre) :
  if(len(answer) == N) :
    return
  temp = [pre]
  while(len(temp) != 0) :
    now = temp[0]
    temp.remove(now)
    for j in (vector[now]) :
      if (((j in answer) == 0) and  ((j in temp) == 0)):
        answer.append(j)
        temp.append(j)

N, M, V = map(int, sys.stdin.readline().split())
vector = [[] for i in range(N + 1)]

for i in range(M) :
  a, b = map(int, sys.stdin.readline().split())
  vector[a].append(b)
  vector[b].append(a)

for i in range(N + 1) :
  vector[i].sort()

answer = [V]
dfs(V)
for i in (answer) :
  if (i == answer[-1]) :
    print(i, end ="")
    break
  print(i, end = " ")
print()

answer = [V]
bfs(V)
for i in (answer) :
  if (i == answer[-1]) :
    print(i, end ="")
    break
  print(i, end = " ")
print()