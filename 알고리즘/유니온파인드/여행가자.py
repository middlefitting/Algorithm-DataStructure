import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
uf = [-1] * N


def find(a):
    if uf[a] < 0 :
        return a
    uf[a] = find(uf[a])
    return uf[a]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    uf[b] = a
    return False


for i in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(len(temp)):
        if temp[j]:
            merge(i, j)

trip = list(map(int, sys.stdin.readline().split()))

start = trip[0] - 1
for i in range(1, M):
    if not merge(start, trip[i] - 1):
        print("NO")
        sys.exit()

print("YES")
