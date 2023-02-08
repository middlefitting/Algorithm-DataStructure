import sys
import heapq

heap = []
answer = 0
T = int(input())
for i in range(T):
    heapq.heappush(heap, int(sys.stdin.readline()))

while len(heap) > 1:
    a = heapq.heappop(heap)
    b = heapq.heappop(heap)
    heapq.heappush(heap, a + b)
    answer = answer + a + b

print(answer)
