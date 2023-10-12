from collections import deque


def solution(prices):
    answer = [0] * len(prices)
    queue = deque(prices)
    save = deque()

    idx = -1
    while queue:
        idx += 1
        temp = queue.popleft()
        while save:
            top = save.popleft()
            if top[0] <= temp:
                save.appendleft(top)
                break
            else:
                answer[top[1]] = idx - top[1]
        save.appendleft([temp, idx])

    while save:
        top = save.popleft()
        answer[top[1]] = idx - top[1]
    return answer

print(solution([1, 2, 3, 2, 3]))