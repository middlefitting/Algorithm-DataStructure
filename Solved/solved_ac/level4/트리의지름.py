import sys
from collections import deque

N = int(sys.stdin.readline())
vector = [[] for _ in range(N)]
for _ in range(N):
    temp = list(map(int, sys.stdin.readline().split()))
    for i in range((len(temp) // 2) - 1):
        vector[temp[0] - 1].append([temp[2 * i + 1] - 1, temp[2 * i + 2]])

first = [1000000000] * N
first[0] = 0
visit = [0] * N


def dfs(x, depth):
    for i in (vector[x]):
        first[i[0]] = min(first[i[0]], depth + i[1])
        if ((i[0] in visit) == False):
            visit.append(i[0])
            dfs(i[0], depth + i[1])
            visit.remove(i[0])


def bfs(x):
    queue = deque([])
    queue.append(x)
    while (queue):
        tx = queue.popleft()
        for i in (vector[tx]):
            first[i[0]] = min(first[i[0]], first[tx] + i[1])
            if (not visit[i[0]]):
                visit[i[0]] = 1
                queue.append(i[0])


bfs(0)
big = [0, 0]
for i in range(N):
    if (big[1] < first[i]):
        big[0] = i
        big[1] = first[i]

first = [1000000000] * N
first[big[0]] = 0
visit = [0] * N
bfs(big[0])
print(max(first))
