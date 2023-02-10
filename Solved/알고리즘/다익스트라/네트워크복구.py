import heapq
import math

N, K = map(int, input().split())
vec = [[] for _ in range(N + 1)]
for _ in range(K):
    a, b, c = map(int, input().split())
    vec[a].append([b, c])
    vec[b].append([a, c])
v = [0] * (N + 1)
p = [0] * (N + 1)
d = [math.inf] * (N + 1)
d[1] = 0
heap = []
heapq.heappush(heap, [0, 1])
while heap:
    dx, x = heapq.heappop(heap)
    if v[x]:
        continue
    v[x] = 1
    for y, dxy in vec[x]:
        if dx + dxy < d[y]:
            d[y] = dx + dxy
            p[y] = x
            heapq.heappush(heap, [d[y], y])

print(N - 1)
for i in range(2, N + 1):
    print(i, p[i])

