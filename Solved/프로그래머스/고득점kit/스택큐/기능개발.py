from collections import deque


def solution(progresses, speeds):
    answer = []
    queue = deque([])
    for i in range(len(progresses)):
        temp = (100 - progresses[i]) // speeds[i]
        if (100 - progresses[i]) % speeds[i]:
            temp += 1
        queue.append(temp)
    while queue:
        temp = 1
        x = queue.popleft()
        while queue:
            y = queue.popleft()
            if y <= x:
                temp += 1
            else:
                queue.appendleft(y)
                break
        answer.append(temp)
    return answer

print(solution([93, 30, 55], [1, 30, 5]))