import heapq
import math


def dijkstra(s):
    v = [0] * N
    heap = [[0, s]]
    while heap:
        dx, x = heapq.heappop(heap)
        if v[x]:
            continue
        v[x] = 1
        for y, dxy in vec[x]:
            if dx + dxy < d[s][y]:
                d[s][y] = dx + dxy
                heapq.heappush(heap, [d[s][y], y])


if __name__ == "__main__":
    N = int(input())
    vec = [[] for _ in range(N)]
    d = [[math.inf] * N for _ in range(N)]
    for i in range(N):
        temp = list(map(int, input().split()))
        for j in range(N):
            if temp[j]:
                vec[i].append([j, 1])
    for i in range(N):
        dijkstra(i)
    for i in range(N):
        for j in range(N):
            if d[i][j] == math.inf:
                print(0, end=" ")
            else:
                print(1, end=" ")
        print()