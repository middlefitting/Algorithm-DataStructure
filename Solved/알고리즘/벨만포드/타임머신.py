import sys
import math
INF = math.inf
N, M = map(int, sys.stdin.readline().split())
adj = [[] for _ in range(N + 1)]
dist = [INF] * (N + 1)
dist[1] = 0
minCycle = False

for i in range(M):
    a, b, c = map(int, sys.stdin.readline().split())
    adj[a].append([b, c])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        for nex, d in adj[j]:
            if (dist[j] != INF) and (dist[nex] > dist[j] + d):
                dist[nex] = dist[j] + d
                if (i == N):
                    minCycle = True
                    print(-1)
                    sys.exit()

for i in range(2, N + 1):
    if dist[i] == INF:
        print(-1)
    else:
        print(dist[i])


