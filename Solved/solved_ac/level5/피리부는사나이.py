import sys

N, M = map(int, sys.stdin.readline().split())
p = [-1] * (N * M)
arr = []
move = dict()
move["D"] = M
move["U"] = -M
move["R"] = 1
move["L"] = -1
for i in range(N):
    arr.append([])
    temp = str(sys.stdin.readline())
    for j in range(M):
        arr[i].append(temp[j])


def find(n):
    if p[n] < 0:
        return n
    p[n] = find(p[n])
    return p[n]


def merge(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    p[b] = a
    return


for i in range(N):
    for j in range(M):
        a = i * M + j
        b = a + move.get(arr[i][j])
        merge(a, b)

print(p.count(-1))
