import sys


def dfs(x):
    if (d[x]):
        return
    d[x] = 1
    q = []
    answer = [x]
    now = x
    while (True):
        for i in (vector[now]):
            if (d[i] == 0):
                d[i] = 1
                q.append(i)
                answer.append(i)
        if (len(q) == 0):
            break
        now = q[0]
        q.remove(q[0])

    if (len(answer) > 0):
        count.append(len(answer))


N = int(sys.stdin.readline())
house = [[] for _ in range(N)]
vector = [[] for _ in range(N * N)]
live = []
count = []
d = [0] * (N * N)

for i in range(N):
    temp = str(sys.stdin.readline())
    for j in range(N):
        house[i].append(int(temp[j]))
        if (house[i][j]):
            live.append(i * N + j)

for i in range(N):
    for j in range(N):
        if (house[i][j]):
            if ((i + 1 < N) and (house[i + 1][j])):
                vector[i * N + j].append((i + 1) * N + j)
                vector[(i + 1) * N + j].append(i * N + j)
            if ((j + 1 < N) and (house[i][j + 1])):
                vector[i * N + j].append(i * N + j + 1)
                vector[i * N + j + 1].append(i * N + j)

for i in (live):
    dfs(i)

print(len(count))
count.sort()
for i in (count):
    print(i)
