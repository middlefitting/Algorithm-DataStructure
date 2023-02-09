import heapq
import math

N, E = map(int, input().split())
vec = [[] for _ in range(N + 1)]
for _ in range(E):
    a, b, c = map(int, input().split())
    vec[a].append([b, c])
    vec[b].append([a, c])
A, B = map(int, input().split())
s_dist = [[math.inf] * (N + 1) for _ in range(N + 1)]


def dijkstra(start):
    heap = []
    heapq.heappush(heap, [0, start])
    s_dist[start][start] = 0
    v = [0] * (N + 1)
    while heap:
        dx, x = heapq.heappop(heap)
        if v[x] != 0:
            continue
        v[x] = 1
        for y, dxy in vec[x]:
            if dx + dxy < s_dist[start][y]:
                s_dist[start][y] = dx + dxy
                heapq.heappush(heap, [s_dist[start][y], y])


dijkstra(1)
dijkstra(A)
dijkstra(B)
answer = s_dist[1][A] + s_dist[A][B] + s_dist[B][N]
answer = min(answer, s_dist[1][B] + s_dist[B][A] + s_dist[A][N])
if answer == math.inf:
    print(-1)
else:
    print(answer)