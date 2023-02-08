from collections import deque

N, M = map(int, input().split())
arr = []
uf = [-1] * (N * M + 1)
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
v = [[0] * M for _ in range(N)]


def find(a):
    if uf[a] < 0:
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


for i in range(N):
    arr.append(list(str(input())))

queue = deque([])
start = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == '.':
            v[i][j] = 1
            queue.append([i,j])
        if arr[i][j] == 'L':
            v[i][j] = 1
            start.append([i, j])
            queue.append([i, j])

answer = 0
temp = deque([])
while True:
    while queue:
        x = queue.popleft()
        arr[x[0]][x[1]] = '.'
        for dx, dy in mv:
            y = [x[0] + dx, x[1] + dy]
            if 0 <= y[0] < N and 0 <= y[1] < M:
                if arr[y[0]][y[1]] == 'X':
                    if v[y[0]][y[1]] == 0:
                        v[y[0]][y[1]] = 1
                        temp.append(y)
                elif merge(x[0] * M + x[1], y[0] * M + y[1]):
                    if v[y[0]][y[1]] == 0:
                        v[y[0]][y[1]] = 1
                        queue.append(y)
    if find(start[0][0] * M + start[0][1]) == find(start[1][0] * M + start[1][1]):
        print(answer)
        break
    answer += 1
    while temp:
        queue.append(temp.popleft())
