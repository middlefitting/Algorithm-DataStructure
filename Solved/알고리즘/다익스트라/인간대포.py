import heapq
import math


def get_dist(a, b):
    return ((a[0] - b[0])**2 + (a[1] - b[1])**2) ** 0.5


def get_walk_time(a, b):
    dist = get_dist(a, b)
    return dist / 5


def get_cannon_time(a, b):
    dist = get_dist(a, b)
    return (abs(dist - 50) / 5) + 2


node = []
start = list(map(float, input().split()))
node.append(start)
end = list(map(float, input().split()))
N = int(input())
for _ in range(N):
    tc = list(map(float, input().split()))
    node.append(tc)
node.append(end)

d = [math.inf] * (N + 3)
v = [0] * (N + 3)
heap = []
heapq.heappush(heap, [0, 1])
while heap:
    dx, x = heapq.heappop(heap)
    if v[x] != 0:
        continue
    v[x] = 1
    for i in range(1, N + 3):
        if i == x:
            continue
        time = get_walk_time(node[x - 1], node[i - 1])
        if x != 1 and x != (N + 2):
            time = min(time, get_cannon_time(node[x - 1], node[i - 1]))
        if time + dx < d[i]:
            d[i] = time + dx
            heapq.heappush(heap, [d[i], i])
print(d[N + 2])
