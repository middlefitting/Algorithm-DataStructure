import heapq

"""
- 메모리 관리를 위해 최소 Heap이 크기가 N인 것을 유지 
- Heap의 최상단 요소가 정답 
"""
if __name__ == "__main__":
    N = int(input())
    heap = []

    for _ in range(N):
        temp = list(map(int, input().split()))
        for i in temp:
            heapq.heappush(heap, i)
        while len(heap) != N:
            heapq.heappop(heap)
    print(heapq.heappop(heap))
