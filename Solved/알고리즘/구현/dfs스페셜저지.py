import sys

N = int(sys.stdin.readline())
idx = 1
s = set()
for _ in range(N - 1):
    s.add(tuple(map(int, sys.stdin.readline().split())))
arr = list(map(int, input().split()))
if arr[0] != 1:
    print(0)
    sys.exit(0)


def dfs(n):
    global idx
    global N
    while idx < N and (((arr[idx], n) in s) or ((n, arr[idx]) in s)):
        idx += 1
        dfs(arr[idx - 1])


dfs(1)
if idx == N:
    print(1)
else:
    print(0)
