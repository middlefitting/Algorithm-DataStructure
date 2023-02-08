import sys

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
fSum = [0] * (N + 1)
for i in range(1, N + 1):
    fSum[i] = fSum[i - 1] + arr[i - 1]

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(fSum[b] - fSum[a - 1])
