import sys
from collections import deque

T = int(sys.stdin.readline())
for _ in range(T):
    N, K = map(int, sys.stdin.readline().split())
    time = list(map(int, sys.stdin.readline().split()))
    result = [0] * N
    inDegree = [0] * N
    vec = [[] for _ in range(N)]

    for __ in range(K):
        a, b = map(int, sys.stdin.readline().split())
        a -= 1
        b -= 1
        vec[a].append(b)
        inDegree[b] += 1

    dest = int(sys.stdin.readline()) - 1
    queue = deque([])

    for i in range(N):
        if inDegree[i] == 0:
            queue.append(i)
            result[i] = time[i]

    while(queue):
        x = queue.popleft()
        for y in vec[x]:
            result[y] = max(result[y], result[x] + time[y])
            inDegree[y] -= 1
            if inDegree[y] == 0:
                queue.append(y)

    print(result[dest])
