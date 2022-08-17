import sys
from collections import deque

N = int(sys.stdin.readline())
vector = [[] for _ in range(N + 1)]
v = [0] * (N + 1)
for _ in range(N - 1):
    a, b = map(int, sys.stdin.readline().split())
    vector[a].append(b)
    vector[b].append(a)


def bfs():
    queue = deque([])
    queue.append(1)
    while (queue):
        x = queue.popleft()
        for y in (vector[x]):
            if (v[y] == 0):
                v[y] = x
                queue.append(y)


bfs()
for i in range(2, N + 1):
    print(v[i])
