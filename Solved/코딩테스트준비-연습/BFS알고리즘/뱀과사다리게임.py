from collections import deque

N, M = map(int, input().split())
event = dict()
mv = [1, 2, 3, 4, 5, 6]
v = [0] * 101
queue = deque([])

for i in range(101):
    event[i] = 0
for _ in range(N + M):
    a, b = map(int, input().split())
    event[a] = b

queue.append([1, 0])
v[1] = 1
while deque:
    x, temp = queue.popleft()
    if x == 100:
        print(temp)
        break
    for i in mv:
        y = x + i
        if y > 100:
            continue
        if event[y] != 0:
            y = event[y]
        if v[y] == 0:
            queue.append([y, temp + 1])
            v[y] = 1

