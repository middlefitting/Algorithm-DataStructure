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


def bfs(x):
    queue = deque([])
    queue.append(x)
    while (queue):
        tx = queue.popleft()
        for i in (vector[tx]):
            if (arr[x][i[0]] > arr[x][tx] + i[1]):
                queue.append(i[0])
                arr[x][i[0]] = min(arr[x][i[0]], arr[x][tx] + i[1])


for i in range(N):
    bfs(i)

answer = 0
for i in range(N):
    temp = 0
    temp += arr[i][X - 1]
    temp += arr[X - 1][i]
    answer = max(answer, temp)

print(answer)
