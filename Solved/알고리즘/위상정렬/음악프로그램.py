# 6 3
# 3 1 4 3
# 4 6 2 5 4
# 2 2 3

import sys
from collections import deque

N ,M = map(int, sys.stdin.readline().split())
vec = [[] for _ in range(N)]
indegree = [0 for _ in range(N)]
answer = []

for i in range(M):
    temp = list(map(int, sys.stdin.readline().split()))
    for j in range(1, temp[0]):
        vec[temp[j] - 1].append(temp[j + 1] - 1)
        indegree[temp[j + 1] - 1] += 1

queue = deque([])
for i in range(N):
    if indegree[i] == 0:
        queue.append(i)

for i in range(N):
    if not queue:
        print(0)
        sys.exit()
    x = queue.popleft()
    answer.append(x)
    for y in vec[x]:
        indegree[y] -= 1
        if indegree[y] == 0:
            queue.append(y)

for i in range(N):
    print(answer[i] + 1)
