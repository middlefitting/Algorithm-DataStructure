import heapq

for _ in range(int(input())):
    heap = []
    for __ in range(int(input())):
        price, name = map(str, input().split())
        heapq.heappush(heap, [int(price) * -1, name])
    rookie = heapq.heappop(heap)[1]
    print(rookie)
