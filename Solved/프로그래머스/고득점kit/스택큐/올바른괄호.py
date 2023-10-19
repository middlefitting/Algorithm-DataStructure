from collections import deque


def solution(s):
    queue = deque([])
    for i in s:
        if i == '(':
            queue.appendleft(i)
        else:
            if queue:
                top = queue.popleft()
                if top == '(':
                    continue
                else:
                    queue.appendleft(top)
                    queue.appendleft(i)
            else:
                queue.append(i)
    return len(queue) == 0


print(solution("()()"))