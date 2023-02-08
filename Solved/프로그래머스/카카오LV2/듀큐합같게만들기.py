from collections import deque

def solution(queue1, queue2):
    total = len(queue1) + len(queue2)
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    q1 = deque(queue1)
    q2 = deque(queue2)
    answer = 0
    while True:
        if sum1 == sum2:
            break
        if (not q1) or (not q2):
            return -1
        if sum1 > sum2:
            temp = q1.popleft()
            q2.append(temp)
            sum1 -= temp
            sum2 += temp
            answer += 1
        else:
            temp = q2.popleft()
            q1.append(temp)
            sum2 -= temp
            sum1 += temp
            answer += 1
        if answer > total:
            return -1
    return answer
