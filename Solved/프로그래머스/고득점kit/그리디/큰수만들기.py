from collections import deque


def top_or_next(queue, k):
    temp = deque([])
    a = queue.popleft()
    while queue and k > 0:
        b = queue.popleft()
        if a < b:
            if temp:
                a = temp.pop()
                queue.appendleft(b)
            else:
                a = b
            k -= 1
            continue
        temp.append(a)
        a = b
    temp.append(a)
    while k > 0:
        temp.pop()
        k -= 1
    while temp:
        queue.appendleft(temp.pop())


def solution(number, k):
    answer = ''
    queue = deque(list(number))
    top_or_next(queue, k)
    while queue:
        answer += queue.popleft()
    return answer