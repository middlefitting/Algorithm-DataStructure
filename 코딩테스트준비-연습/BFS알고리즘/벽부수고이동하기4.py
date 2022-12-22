from collections import deque

N, M = map(int, input().split())
arr = []
uf = [-1] * N * M
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
for i in range(N):
    arr.append(list(str(input())))


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[a] += uf[b]
    uf[b] = a


queue = deque([])
for i in range(N):
    for j in range(M):
        if arr[i][j] == '0':
            queue.append([i, j])

v = [[0] * M for _ in range(N)]
while queue:
    x = queue.popleft()
    v[x[0]][x[1]] = 1
    for [dx, dy] in mv:
        y = [x[0] + dx, x[1] + dy]
        if 0 <= y[0] < N and 0 <= y[1] < M:
            if arr[y[0]][y[1]] == '0':
                merge(x[0] * M + x[1], y[0] * M + y[1])
                if v[y[0]][y[1]] == 0:
                    v[y[0]][y[1]] = 1
                    queue.append(y)


for i in range(N):
    for j in range(M):
        if arr[i][j] == '1':
            temp = set()
            for [dx, dy] in mv:
                y = [i + dx, j + dy]
                if 0 <= y[0] < N and 0 <= y[1] < M:
                    if arr[y[0]][y[1]] == '0':
                        temp.add(find(y[0] * M + y[1]))
            result = 1
            for ty in temp:
                result -= uf[ty]
            arr[i][j] = result % 10

for i in range(N):
    for j in range(M):
        print(arr[i][j], end="")
    print()
