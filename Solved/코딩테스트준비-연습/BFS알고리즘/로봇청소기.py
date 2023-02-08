import math
from collections import deque

while True:
    M, N = map(int, input().split())
    if M == 0 and N == 0:
        break
    arr = [list(str(input())) for _ in range(N)]
    mv = [[1,0], [-1, 0], [0, 1], [0, -1]]
    start = deque()
    queue = deque()
    count = 0
    answer = -1
    length = dict([])
    trash = []
    begin = []
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 'o':
                queue.append([i, j])
                start.append([i, j])
                begin.append([i, j])
            if arr[i][j] == '*':
                start.append([i, j])
                count += 1
                trash.append([i, j])
    v = [[0] * M for _ in range(N)]
    find = 0
    while queue:
        x, y = queue.popleft()
        v[x][y] = 1
        if arr[x][y] == '*':
            find += 1
        for mx, my in mv:
            tx, ty = mx + x, my + y
            if 0 <= tx < N and 0 <= ty < M:
                if v[tx][ty] == 0 and arr[tx][ty] != 'x':
                    queue.append([tx, ty])
                    v[tx][ty] = 1
    if find != count:
        print(-1)
        continue

    while start:
        v = [[0] * M for _ in range(N)]
        X, Y = start.popleft()
        queue.append([X, Y, 0])
        while queue:
            x, y, temp = queue.popleft()
            v[x][y] = 1
            if arr[x][y] == '*':
                length[str(X) + '@' + str(Y) + '@' + str(x) + '@' + str(y)] = temp
            for mx, my in mv:
                tx, ty = mx + x, my + y
                if 0 <= tx < N and 0 <= ty < M:
                    if v[tx][ty] == 0 and arr[tx][ty] != 'x':
                        queue.append([tx, ty, temp + 1])
                        v[tx][ty] = 1

    answer = [math.inf]


    def dfs(x, y, depth, temp, trashs):
        if depth == count:
            answer[0] = min(answer[0], temp)
            return
        for i in range(len(trashs)):
            tx, ty = trashs[i]
            t_trash = trashs.copy()
            t_trash.pop(i)
            dfs(tx, ty, depth + 1, temp + length[str(x) + '@' + str(y) + '@' + str(tx) + '@' + str(ty)], t_trash)


    dfs(begin[0][0], begin[0][1], 0, 0, trash)
    print(answer[0])