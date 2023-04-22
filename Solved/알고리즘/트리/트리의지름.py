import math
import sys
import heapq


def dijkstra(s):
    v = [0] * (N + 1)
    d = [math.inf] * (N + 1)
    d[0] = 0
    d[s] = 0
    heap = [[0, s]]
    while heap:
        dx, x = heapq.heappop(heap)
        if v[x]:
            continue
        v[x] = 1
        for y, dxy in vec[x]:
            if dxy + dx <= d[y]:
                d[y] = dxy + dx
                heapq.heappush(heap, [d[y], y])
    result = d.index(max(d))
    return [result, max(d)]


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    vec = [[] for _ in range(N + 1)]
    for _ in range(N - 1):
        a, b, c = map(int, sys.stdin.readline().split())
        vec[a].append([b, c])
        vec[b].append([a, c])
    y = dijkstra(1)[0]
    if N != 1:
        print(dijkstra(y)[1])
    else:
        print(0)
