from collections import deque


def solution(arr):
    answer = []
    queue = deque([])
    for i in range(len(arr)):
        if i == 0:
            queue.append(arr[i])
        else:
            bottom = queue.pop()
            queue.append(bottom)
            if bottom != arr[i]:
                queue.append(arr[i])
    while queue:
        answer.append(queue.popleft())
    return answer
