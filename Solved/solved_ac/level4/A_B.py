import sys

sys.setrecursionlimit(10**5)

A, B = map(int, input().split())


def dfs(temp, depth):
    if (temp == B):
        print(depth)
        sys.exit(0)
    if (temp > 10e9):
        return
    if (temp < B):
        dfs(temp * 2, depth + 1)
        dfs(temp * 10 + 1, depth + 1)


dfs(A, 1)
print(-1)
