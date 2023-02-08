# 티떱숲의 지도는 R행 C열로 이루어져 있다. 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다.
# 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로 나타내어져 있다.
from collections import deque


N, M = map(int, input().split())
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
arr = []
p = [[0] * M for _ in range(N)]
kosumdochi = deque([])
water = deque([])
answer = 0
for i in range(N):
    arr.append(list(str(input())))

for i in range(N):
    for j in range(M):
        if arr[i][j] == 'S':
            kosumdochi.append([i, j])
            p[i][j] = 1
        if arr[i][j] == '*':
            water.append([i, j])

while kosumdochi:
    temp_water = []
    while water:
        x = water.popleft()
        for [dx, dy] in mv:
            y = [x[0] + dx, x[1] + dy]
            if 0 <= y[0] < N and 0 <= y[1] < M:
                if arr[y[0]][y[1]] not in ['*', 'X', 'D']:
                    arr[y[0]][y[1]] = '*'
                    temp_water.append(y)
    for i in temp_water:
        water.append(i)

    temp_kosumdochi = []
    while kosumdochi:
        x = kosumdochi.popleft()
        for [dx, dy] in mv:
            y = [x[0] + dx, x[1] + dy]
            if 0 <= y[0] < N and 0 <= y[1] < M:
                if (arr[y[0]][y[1]] not in ['*', 'X']) and (not p[y[0]][y[1]]):
                    p[y[0]][y[1]] = p[x[0]][x[1]] + 1
                    temp_kosumdochi.append(y)
                    if arr[y[0]][y[1]] == 'D':
                        answer = p[x[0]][x[1]]
    for i in temp_kosumdochi:
        kosumdochi.append(i)

if answer != 0:
    print(answer)
else:
    print("KAKTUS")
