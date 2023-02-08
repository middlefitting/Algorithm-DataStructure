import sys
from collections import deque

M, N, H = map(int, sys.stdin.readline().split())
mv = [[1, 0, 0], [-1, 0, 0], [0, 1, 0], [0, -1, 0], [0, 0, 1], [0 , 0, -1]]
queue = deque([])
arr = []
answer = 0
possible = True

for i in range(H):
    arr.append([])
    for j in range(N):
        arr[i].append(list(map(int, sys.stdin.readline().split())))

for h in range(H):
    for i in range(N):
        for j in range(M):
            if arr[h][i][j] == 1:
                queue.append([[h, i, j], 0])

while queue:
    x, temp = queue.popleft()
    answer = max(answer, temp)
    for [dh, dx, dy] in mv:
        y = [x[0] + dh, x[1] + dx, x[2] + dy]
        if 0 <= y[0] < H and 0 <= y[1] < N and 0 <= y[2] < M:
            if arr[y[0]][y[1]][y[2]] == 0:
                arr[y[0]][y[1]][y[2]] = 1
                queue.append([y, temp + 1])

for h in range(H):
    for i in range(N):
        for j in range(M):
            if arr[h][i][j] == 0:
                possible = False

if possible:
    print(answer)
else:
    print(-1)
