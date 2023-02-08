from collections import deque

mv = [[-1, 0], [0, -1], [0, 1], [1, 0]]
shark = 2
eat = 0
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
queue = deque([])
temp = deque([])
for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            arr[i][j] = 0
            queue.append([[i, j], 0])

v = [[0] * N for _ in range(N)]
answer = 0
while queue:
    x, tanswer = queue.popleft()
    v[x[0]][x[1]] = 1
    if 0 < arr[x[0]][x[1]] < shark:
        while queue:
            tx, ttanswer = queue.popleft()
            if ttanswer == tanswer and 0 < arr[tx[0]][tx[1]] < shark:
                if tx[0] < x[0] or (tx[0] == x[0] and tx[1] < x[1]):
                    x[0] = tx[0]
                    x[1] = tx[1]
        answer = tanswer
        eat += 1
        if eat == shark:
            eat = 0
            shark += 1
        arr[x[0]][x[1]] = 0
        v = [[0] * N for _ in range(N)]
        v[x[0]][x[1]] = 1
    possible = False
    for i in range(N):
        for j in range(N):
            if 0 < arr[i][j] < shark:
                possible = True
    if not possible:
        break
    for mx, my in mv:
        tx, ty = x[0] + mx, x[1] + my
        if 0 <= tx < N and 0 <= ty < N:
            if arr[tx][ty] <= shark and v[tx][ty] == 0:
                v[tx][ty] = 1
                queue.append([[tx, ty], tanswer + 1])

print(answer)
