import heapq


def solution(jobs):
    now = 0
    job_size = len(jobs)
    s = 0
    heapq.heapify(jobs)
    wait = []

    while True:
        while True:
            if jobs:
                temp = heapq.heappop(jobs)
                if temp[0] <= now:
                    heapq.heappush(wait, [temp[1], temp[0]])
                else:
                    heapq.heappush(jobs, temp)
                    break
            else:
                break
        if not wait:
            temp = heapq.heappop(jobs)
            heapq.heappush(wait, [temp[1], temp[0]])
            now = temp[0]

        temp = heapq.heappop(wait)
        now += temp[0]
        s += (now - temp[1])
        if (not jobs) and (not wait):
            break
    return s // job_size


print(solution([[1, 9], [0, 3], [2, 6]]))
