from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    wait = deque(truck_weights)
    crossing = deque([0] * bridge_length)
    bridge_weight = 0
    while wait:
        answer += 1
        bridge_weight -= crossing.popleft()
        temp = wait.popleft()
        if bridge_weight + temp <= weight:
            bridge_weight += temp
            crossing.append(temp)
        else:
            wait.appendleft(temp)
            crossing.append(0)
    while bridge_weight > 0:
        answer += 1
        bridge_weight -= crossing.popleft()
        crossing.append(0)
    return answer
