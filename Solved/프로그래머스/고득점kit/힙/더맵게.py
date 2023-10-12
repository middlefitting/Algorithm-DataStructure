import heapq
from heapq import heapify


def solution(scoville, K):
    heapify(scoville)
    answer = 0
    while scoville:
        a = heapq.heappop(scoville)
        if a >= K:
            return answer
        elif not scoville:
            return -1
        else:
            answer += 1
            b = heapq.heappop(scoville)
            heapq.heappush(scoville, a + b * 2)


print(solution([3, 9, 10, 12, 1, 2], 7))
