import math
from collections import deque

K = int(input())
M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
v = [[[0] * (K + 1) for _ in range(M)] for _ in range(N)]
mx = [1, -1, 0, 0]
my = [0, 0, 1, -1]
mhx = [2, 2, -2, -2, 1, -1, 1, -1]
mhy = [1, -1, 1, -1, 2, 2, -2, -2]
queue = deque([[0, 0, 0, 0]])
v[0][0][0] = 1
answer = math.inf

while queue:
    x, y, k, temp = queue.popleft()
    if x == (N - 1) and y == (M - 1):
        answer = min(answer, temp)
    for i in range(4):
        tx, ty = x + mx[i], y + my[i]
        if not (0 <= tx < N and 0 <= ty < M):
            continue
        if arr[tx][ty] == 1:
            continue
        if v[tx][ty][k] == 1:
            continue
        v[tx][ty][k] = 1
        queue.append([tx, ty, k, temp + 1])
    for i in range(8):
        tx, ty, tk = x + mhx[i], y + mhy[i], k + 1
        if tk > K:
            break
        if not (0 <= tx < N and 0 <= ty < M):
            continue
        if arr[tx][ty] == 1:
            continue
        if v[tx][ty][tk] == 1:
            continue
        v[tx][ty][tk] = 1
        queue.append([tx, ty, tk, temp + 1])

if answer == math.inf:
    print(-1)
else:
    print(answer)
