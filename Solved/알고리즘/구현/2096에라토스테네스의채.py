from collections import deque

N, K = map(int, input().split())
queue = deque([i for i in range(2, N + 1)])

answer = 0
while answer < K:
    x = queue.popleft()
    answer += 1
    if answer == K:
        print(x)
    for _ in range(len(queue)):
        y = queue.popleft()
        if y % x == 0:
            answer += 1
            if answer == K:
                print(y)
        else:
            queue.append(y)
