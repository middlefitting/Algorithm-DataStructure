import math
import heapq

N, V = map(int, input().split())
S = int(input())
d = [math.inf] * (N + 1)
d[S] = 0
vec = [[] for _ in range(N + 1)]
for i in range(V):
    a, b, c = map(int, input().split())
    vec[a].append([b, c])
heap = []
heapq.heappush(heap, [0, S])
v = [0] * (N + 1)
while heap:
    dist, x = heapq.heappop(heap)
    if v[x] == 1:
        continue
    v[x] = 1
    for [y, temp] in vec[x]:
        if dist + temp < d[y]:
            d[y] = dist + temp
            heapq.heappush(heap, [d[y], y])
for i in range(1, N + 1):
    if d[i] == math.inf:
        print("INF")
    else:
        print(d[i])
