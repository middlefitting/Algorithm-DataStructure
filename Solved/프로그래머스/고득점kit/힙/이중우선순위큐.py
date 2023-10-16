import heapq


def solution(operations):
    db = dict()
    max_heap = []
    min_heap = []
    for i in operations:
        oper, num = i.split()
        num = int(num)
        if oper == "I":
            heapq.heappush(max_heap, num * -1)
            heapq.heappush(min_heap, num)
            try:
                db[num] += 1
            except KeyError:
                db[num] = 1
        elif oper == "D":
            if num == -1:
                while min_heap:
                    temp = heapq.heappop(min_heap)
                    if db[temp] > 0:
                        db[temp] -= 1
                        break
            elif num == 1:
                while max_heap:
                    temp = heapq.heappop(max_heap) * -1
                    if db[temp] > 0:
                        db[temp] -= 1
                        break
    answer = []
    for key, value, in db.items():
        if value:
            answer.append(key)
    if not answer:
        return [0, 0]
    return [max(answer), min(answer)]

print(solution(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))
print(solution(["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]))