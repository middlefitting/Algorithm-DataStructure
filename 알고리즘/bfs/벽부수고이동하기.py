import sys
from collections import deque

N, M = map(int, input().split())
v = [[[0] * M for _ in range(N)] for _ in range(2)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
queue = deque([])
temp_arr = []

for i in range(N):
    temp_arr.append(list(str(input())))

arr = [temp_arr.copy() for _ in range(2)]

queue.append([0, 0, 0])
v[0][0][0] = 1
answer = 0
while queue:
    x = queue.popleft()
    if x[1] == (N - 1) and x[2] == (M - 1):
        if answer != 0:
            answer = min(answer, v[x[0]][x[1]][x[2]])
        else:
            answer = v[x[0]][x[1]][x[2]]
    for [dx, dy] in mv:
        y = [x[0], x[1] + dx, x[2] + dy]
        if 0 <= y[0] <= 1 and 0 <= y[1] < N and 0 <= y[2] < M and (not v[y[0]][y[1]][y[2]]):
            if arr[y[0]][y[1]][y[2]] == '0':
                v[y[0]][y[1]][y[2]] = v[x[0]][x[1]][x[2]] + 1
                queue.append([y[0], y[1], y[2]])

            if y[0] < 1 and arr[y[0]][y[1]][y[2]] == '1' and (not v[y[0]][y[1]][y[2]]):
                v[y[0]][y[1]][y[2]] = -1
                v[y[0] + 1][y[1]][y[2]] = v[x[0]][x[1]][x[2]] + 1
                queue.append([y[0] + 1, y[1], y[2]])


if answer != 0:
    print(answer)
else:
    print(-1)

