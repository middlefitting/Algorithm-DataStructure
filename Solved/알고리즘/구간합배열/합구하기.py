import sys

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
fSum = [0] * (N + 1)
for i in range(1, N + 1):
    fSum[i] = fSum[i - 1] + arr[i - 1]
for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(fSum[b] - fSum[a - 1])
