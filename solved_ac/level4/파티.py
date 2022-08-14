import sys
from collections import deque

N, M, X = map(int, sys.stdin.readline().split())
arr = [[100000000] * N for _ in range(N)]
for i in range(N):
    arr[i][i] = 0
vector = [[] for _ in range(N)]
for i in range(M):
    x, y, L = map(int, sys.stdin.readline().split())
    vector[x - 1].append([y - 1, L])
    arr[x - 1][y - 1] = L

def bfs(x):
    queue = deque([])
    while (True) :
      copy = []
      for i in (arr[x]) :
        copy.append(i)
      v = [0] * N
      queue.append(x)
      while (queue):
          tx = queue.popleft()
          for i in (vector[tx]):
              if (not v[i[0]]):
                  queue.append(i[0])
                  v[i[0]] = 1
              arr[x][i[0]] = min(arr[x][i[0]], arr[x][tx] + i[1])
      if(sum(arr[x]) == sum(copy)) :
        break

for i in range(N):
    bfs(i)

answer = 0
for i in range(N):
    temp = 0
    temp += arr[i][X - 1]
    temp += arr[X - 1][i]
    answer = max(answer, temp)

print(answer)
