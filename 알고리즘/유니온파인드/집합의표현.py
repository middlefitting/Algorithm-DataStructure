import sys

N, M = map(int, sys.stdin.readline().split())
uf = [-1] * (N + 1)


def find(a):
    if uf[a] < 0:
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    uf[b] = a


def isMerge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        print("YES")
    else:
        print("NO")


for _ in range(M):
    f, a, b = map(int, sys.stdin.readline().split())
    if f == 0:
        merge(a, b)
    else:
        isMerge(a, b)
