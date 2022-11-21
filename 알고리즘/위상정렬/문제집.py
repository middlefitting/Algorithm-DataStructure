import sys
import heapq

N, M = map(int, sys.stdin.readline().split())
heap = []
vec = [[] for _ in range(N)]
indegree = [0] * N

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    vec[a - 1].append(b - 1)
    indegree[b - 1] += 1

for i in range(N):
    if indegree[i] == 0:
        heapq.heappush(heap, i)

while heap:
    x = heapq.heappop(heap)
    print(x + 1, end=" ")
    for y in vec[x]:
        indegree[y] -= 1
        if indegree[y] == 0:
            heapq.heappush(heap, y)
print()

