import sys
from collections import deque

N = int(sys.stdin.readline())
A, B = map(int, sys.stdin.readline().split())
M = int(sys.stdin.readline())
son = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, sys.stdin.readline().split())
    son[a].append(b)
    son[b].append(a)

def bfs(a, b):
    s = [0] * (N +1)
    s[a] = 1
    heap = deque([a])
    level = 0
    while heap:
        x = heap.popleft()
        for y in son[x]:
            if not s[y]:
                heap.append(y)
                s[y] = s[x] + 1
            if y == b:
                return s[y] - 1
    return -1


print(bfs(A, B))
