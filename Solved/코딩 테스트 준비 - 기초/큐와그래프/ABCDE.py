import sys

def dfs(depth, pre) :
  if (depth == 5) :
    print(1)
    exit()
  
  for temp in (friend[pre]) :
    if((temp in find) == 0) :
      find.append(temp)
      dfs(depth + 1, temp)
      find.remove(temp)

N = [0]
M = [0]
N[0], M[0] =  map(int, input().split())

friend = [[] for _ in range(N[0])]
for i in range(M[0]) :
  a, b = map(int, sys.stdin.readline().split())
  friend[a].append(b)
  friend[b].append(a)

find = []
for n in range(N[0]) :
  find.append(n)
  dfs(1, n)
  find.remove(n)
print(0)
