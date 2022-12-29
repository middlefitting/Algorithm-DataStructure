import math
from collections import deque

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
virus = []
answer = [math.inf]
find = [False]
C = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == 0:
            C += 1

def dfs(depth, temp):
    if temp == M:
        bfs()
        return
    for i in range(depth, N * N):
        if arr[i // N][i % N] == 2:
            virus.append([i // N, i % N])
            dfs(i + 1, temp + 1)
            virus.pop()


def bfs():
    queue = deque([])
    v = [[0] * N for _ in range(N)]
    count = 0
    for i in virus:
        queue.append(i)
        v[i[0]][i[1]] = 1
    while queue:
        x = queue.popleft()
        if count == C:
            break
        for mx, my in mv:
            tx, ty = x[0] + mx, x[1] + my
            if 0 <= tx < N and 0 <= ty < N:
                if arr[tx][ty] != 1 and v[tx][ty] == 0:
                    v[tx][ty] = v[x[0]][x[1]] + 1
                    queue.append([tx, ty])
                    if arr[tx][ty] == 0:
                        count += 1
    for i in range(N):
        for j in range(N):
            if v[i][j] == 0 and arr[i][j] == 0:
                return
    find[0] = True
    temp = 0
    for i in range(N):
        for j in range(N):
            temp = max(temp, v[i][j])
    answer[0] = min(answer[0], temp - 1)


dfs(0, 0)
if find[0]:
    print(answer[0])
else:
    print(-1)
