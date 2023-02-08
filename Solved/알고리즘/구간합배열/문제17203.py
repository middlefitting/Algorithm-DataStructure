import sys

N, M = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
fSum = [0] * (N + 1)
fSum[1] = abs(arr[0])
for i in range(2, N + 1):
    fSum[i] = fSum[i - 1] + abs(arr[i -1] - arr[i - 2])

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    print(fSum[b] - fSum[a])
