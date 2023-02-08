import heapq
import math

N = int(input())
M = int(input())
vec = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b, d = map(int, input().split())
    vec[a].append([b, d])
A, B = map(int, input().split())

v = [0] * (N + 1)
d = [math.inf] * (N + 1)
d[A] = 0
heap = []
heapq.heappush(heap, [0, A])

while heap:
    dx, x = heapq.heappop(heap)
    if v[x] != 0:
        continue
    v[x] = 1
    for [y, dxy] in vec[x]:
        if dx + dxy < d[y]:
            d[y] = dx + dxy
            heapq.heappush(heap, [d[y], y])

print(d[B])
