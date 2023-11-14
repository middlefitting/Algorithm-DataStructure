from collections import deque

def solution(people, limit):
    people.sort(reverse=True)
    answer = 0
    queue = deque(people)
    while queue:
        answer += 1
        a = queue.popleft()
        if queue:
            b = queue.pop()
            if a + b > limit:
                queue.append(b)
    return answer


