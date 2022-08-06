import sys

sys.setrecursionlimit(10**5)


def dfs(x):
    if (x == 0):
        d[x] == 1
        answer[x] = 1
        return
    for i in (vector[x]):
        answer[x] = min(answer[i] + 1, answer[x])


N, M = map(int, sys.stdin.readline().split())
d = [0] * (N * M)
answer = [10000] * (N * M)
arr = [[] for _ in range(N)]
vector = [[] for _ in range(N * M)]
temp_arr = [0]
for i in range(N):
    temp = str(sys.stdin.readline())
    for j in range(M):
        arr[i].append(int(temp[j]))

for i in range(N):
    for j in range(M):
        if (j + 1 < M):
            if (arr[i][j] and arr[i][j + 1]):
                vector[i * M + j].append(i * M + j + 1)
                vector[i * M + j + 1].append(i * M + j)
        if (i + 1 < N):
            if (arr[i][j] and arr[i + 1][j]):
                vector[i * M + j].append((i + 1) * M + j)
                vector[(i + 1) * M + j].append(i * M + j)
while (1):
    same = True
    temp = answer.copy()
    for x in range(N * M):
        if (arr[x // M][x % M]):
            dfs(x)
        for i in (vector[x]):
            dfs(i)
    for y in range(N * M):
        if (temp[y] != answer[y]):
            same = False
            break
    if (same == True):
        break

print(answer[N * M - 1])
