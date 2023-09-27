from collections import deque

N, K = map(int, input().split())
queue = deque([i for i in range(1, N + 1)])

print("<", end="")
temp = 0
while queue:
    x = queue.popleft()
    temp += 1
    if temp == K:
        if queue:
            print(str(x) + ", ", end="")
        else:
            print(x, end="")
        temp = 0
    else:
        queue.append(x)
print(">")
