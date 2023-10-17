from collections import deque


def solution(array, commands):
    answer = []
    for a, b, c in commands:
        arr = []
        queue = deque(array.copy())
        for _ in range(a - 1):
            queue.popleft()
        for __ in range(b - a + 1):
            arr.append(queue.popleft())
        arr.sort()
        answer.append(arr[c - 1])
    return answer

