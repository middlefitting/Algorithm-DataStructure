from collections import deque

queue = deque([i for i in range(1, int(input()) + 1)])
floor = deque([])

while queue:
    floor.append(queue.popleft())
    if queue:
        queue.append(queue.popleft())

while floor:
    print(floor.popleft(), end=" ")

