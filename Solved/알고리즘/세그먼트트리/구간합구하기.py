import sys

N, M, K = map(int, sys.stdin.readline().split())
tree_size = 1
while tree_size < N:
    tree_size *= 2

arr = [0] * (tree_size * 2)

for i in range(N):
    arr[tree_size + i] = int(sys.stdin.readline())

i = tree_size - 1
while i >= 1:
    arr[i] = arr[i * 2] + arr[i * 2 + 1]
    i -= 1


def update(i, value):
    temp = i + tree_size
    arr[temp] = value
    while temp > 1:
        temp = temp // 2
        arr[temp] = arr[temp * 2] + arr[temp * 2 + 1]


def sumNode(L, R, node, nodeL, nodeR):
    if L > nodeR or R < nodeL:
        return 0
    elif L <= nodeL and nodeR <= R:
        return arr[node]
    else:
        mid = (nodeL + nodeR) // 2

        return sumNode(L, R, node * 2, nodeL, mid) + sumNode(L, R, node * 2 + 1, mid + 1, nodeR)


for i in range(M + K):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        update(b - 1, c)
    if a == 2:
        print(sumNode(b - 1 + tree_size, c - 1 + tree_size, 1, tree_size, tree_size * 2 - 1))
