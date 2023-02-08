import sys
from collections import deque

M, N = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

queue = deque([])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]

for i in range(N):
    for j in range(M):
        if (arr[i][j] == 1):
            queue.append([i, j])


def bfs():
    while (queue):
        x, y = queue.popleft()
        for i in range(4):
            tx, ty = dx[i] + x, dy[i] + y
            if ((0 <= tx < N) and (0 <= ty < M) and (arr[tx][ty] == 0)):
                arr[tx][ty] = arr[x][y] + 1
                queue.append([tx, ty])


max = 0
possible = True
bfs()
for i in range(N):
    for j in range(M):
        if (arr[i][j] == 0):
            possible = False
        if (arr[i][j] > max):
            max = arr[i][j]
if (possible):
    print(max - 1)
else:
    print(-1)
