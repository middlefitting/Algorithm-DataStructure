import sys
from collections import deque

N = int(sys.stdin.readline())
s = set()
for _ in range(N - 1):
    a, b = map(int, sys.stdin.readline().split())
    s.add((a, b))
queue = deque(list(map(int, sys.stdin.readline().split())))
if queue[0] != 1:
    print(0)
    sys.exit(0)
bfs = deque([queue.popleft()])

while bfs:
    x = bfs.popleft()
    while queue:
        if ((x, queue[0]) in s) or ((queue[0], x) in s):
            bfs.append(queue.popleft())
        else:
            break
if queue:
    print(0)
else:
    print(1)
