def solution(n, lost, reserve):
    happy = lost.copy()
    for i in happy:
        if i in reserve:
            reserve.pop(reserve.index(i))
            lost.pop(lost.index(i))
    reserve.sort()
    for i in reserve:
        if i - 1 in lost:
            lost.pop(lost.index(i - 1))
            continue
        if i + 1 in lost:
            lost.pop(lost.index(i + 1))
    return n - len(lost)

print(solution(5, [2, 4], [1, 3, 5]))
print(solution(5, [2, 4], [3]))
print(solution(3, [3], [1]))