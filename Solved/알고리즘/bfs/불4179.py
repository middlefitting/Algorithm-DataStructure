from collections import deque
import sys

N, M = map(int, sys.stdin.readline().split())
v = [[0] * M for _ in range(N)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
arr = []
queue = deque([])
fire = deque([])
for i in range(N):
    arr.append([])
    temp = list(map(str, sys.stdin.readline()))
    for j in range(M):
        arr[i].append(temp[j])
        if arr[i][j] == 'J':
            queue.append([i, j])
            v[i][j] = 1
        if arr[i][j] == 'F':
            fire.append([i, j])

answer = 0
while queue:
    temp_fire = []
    while fire:
        x = fire.popleft()
        for i in mv:
            y = [x[0] + i[0], x[1] + i[1]]
            if 0 <= y[0] < N and 0 <= y[1] < M:
                if arr[y[0]][y[1]] != 'F' and arr[y[0]][y[1]] != '#':
                    temp_fire.append([y[0], y[1]])
                    arr[y[0]][y[1]] = 'F'
    for i in temp_fire:
        fire.append(i)

    temp_queue = []
    while queue:
        x = queue.popleft()
        for i in mv:
            y = [x[0] + i[0], x[1] + i[1]]
            if y[0] < 0 or y[0] >= N or y[1] < 0 or y[1] >= M:
                if answer == 0:
                    answer = v[x[0]][x[1]]
            if 0 <= y[0] < N and 0 <= y[1] < M:
                if arr[y[0]][y[1]] == '.' and v[y[0]][y[1]] == 0:
                    temp_queue.append([y[0], y[1]])
                    arr[y[0]][y[1]] = 'J'
                    v[y[0]][y[1]] = v[x[0]][x[1]] + 1
    for i in temp_queue:
        queue.append(i)

if answer != 0:
    print(answer)
else:
    print("IMPOSSIBLE")



