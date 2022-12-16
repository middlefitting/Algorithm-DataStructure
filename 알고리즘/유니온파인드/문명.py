import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())
uf = [-1] * (N * N + 1)
arr = [[-1] * N for _ in range(N)]
v = [[-1] * N for _ in range(N)]
queue = deque([])
start = deque([])
answer = 0
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
for i in range(K):
    x, y = map(int, sys.stdin.readline().split())
    arr[x-1][y-1] = (x - 1) * N + y - 1
    start.append([[x - 1, y - 1], 0])
    # uf[(x - 1) * N + y - 1] = -1


def find(a):
    if uf[a] < 0:기
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return False
    uf[b] = a
    return True


while start:
    t = start.copy()
    while t:
        x, temp = t.popleft()
        for dx, dy in mv:
            y = [x[0] + dx, x[1] + dy]
            if 0 <= y[0] < N and 0 <= y[1] < N:
                tx = x[0] * N + x[1]
                ty = y[0] * N + y[1]
                result = (find(tx) != find(ty))
                if arr[y[0]][y[1]] != -1 and result:
                    merge(tx, ty)
                    answer += 1
    if answer == (K - 1):
        x, temp = start.popleft()
        print(temp)
        break
    while start:
        x, temp = start.popleft()
        for dx, dy in mv:
            y = [x[0] + dx, x[1] + dy]
            if 0 <= y[0] < N and 0 <= y[1] < N:
                tx = x[0] * N + x[1]
                ty = y[0] * N + y[1]
                result = merge(tx, ty)
                if arr[y[0]][y[1]] != -1 and result:
                    answer += 1

                    # v[y[0]][y[1]] = max(v[y[0]][y[1]], v[x[0]][x[1]] + 1)
                elif result:
                    # v[y[0]][y[1]] = max(v[y[0]][y[1]], v[x[0]][x[1]] + 1)
                    arr[y[0]][y[1]] = arr[x[0]][x[1]]
                    queue.append([y, temp + 1])
                # if answer == (K - 1):
                    # a = 0
                    # for i in range(N):
                    #     for j in range(N):
                    #         a = max(v[i][j], a)
                    # print(a)
                    # print(v)
                    # sys.exit()
    while queue:
        start.append(queue.popleft())
