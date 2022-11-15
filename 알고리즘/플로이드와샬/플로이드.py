import sys
import math

INF = math.inf
N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
arr = [[INF] * N for _ in range(N)]
for i in range(N):
    arr[i][i] = 0

for i in range(M):
    a, b,  c = map(int, sys.stdin.readline().split())
    arr[a-1][b-1] = min(arr[a-1][b-1], c)

for k in range(N):
    for i in range(N):
        for j in range(N):
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])

for i in range(N):
    for j in range(N):
        if arr[i][j] == INF:
            print(0, end= " ")
        else:
            print(arr[i][j], end=" ")
    print()