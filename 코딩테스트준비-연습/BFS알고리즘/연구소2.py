import math
from collections import deque

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = [-1]
virus = []
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]


def dfs(temp, depth):
    if depth == M:
        bfs(virus)
        return
    for i in range(temp + 1, N * N):
        if arr[i // N][i % N] == 2:
            virus.append([i // N, i % N])
            dfs(i, depth + 1)
            virus.pop()


def bfs(tvirus):
    queue = deque([])
    v = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if arr[i][j] == 1:
                v[i][j] = 1
    for i in tvirus:
        queue.append(i)
        v[i[0]][i[1]] = 1
    while queue:
        x = queue.popleft()
        for mx, my in mv:
            tx, ty = x[0] + mx, x[1] + my
            if 0 <= tx < N and 0 <= ty < N:
                if arr[tx][ty] != 1 and v[tx][ty] == 0:
                    queue.append([tx, ty])
                    v[tx][ty] = v[x[0]][x[1]] + 1
    for i in range(N):
        for j in range(N):
            if v[i][j] == 0:
                return
    temp = 0
    for i in range(N):
        for j in range(N):
            temp = max(v[i][j], temp)
    if answer[0] != -1:
        answer[0] = min(temp - 1, answer[0])
    else:
        answer[0] = temp - 1


dfs(-1, 0)
print(answer[0])
