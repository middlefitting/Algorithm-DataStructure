import heapq

K, N = map(int, input().split())
sosu = list(map(int, input().split()))
heap = []
temp = 0
for i in sosu:
    heapq.heappush(heap, i)
for _ in range(N):
    temp = heapq.heappop(heap)
    for i in sosu:
        if temp * i <= 2 ** 31:
            heapq.heappush(heap, temp * i)
        # 중복제거
        if temp % i == 0:
            break
print(temp)
