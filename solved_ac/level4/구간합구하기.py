import sys

N, M = map(int, sys.stdin.readline().split())
dArr = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, N + 1):
        dArr[i][j] = dArr[i][j - 1] + temp[j - 1]
for i in range(M):
    x1, y1, x2, y2 = map(int, sys.stdin.readline().split())
    sum = 0
    for tx in range(x1, x2 + 1):
        sum += dArr[tx][y2] - dArr[tx][y1 - 1]
    print(sum)