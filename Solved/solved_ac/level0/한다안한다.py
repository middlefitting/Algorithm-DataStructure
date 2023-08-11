from collections import deque

for _ in range(int(input())):
    queue = deque(list(str(input())))
    l = 0
    r = 0
    while queue:
        l = int(queue.popleft())
        r = int(queue.pop())
    if l == r:
        print("Do-it")
    else:
        print("Do-it-Not")
