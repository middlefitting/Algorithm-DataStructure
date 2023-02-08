import sys
from collections import deque

S, T = map(int, input().split())
mv = ['*', '+', '-', '/']
v = dict()
queue = deque([])
queue.append(S)
v[S] = ""
while queue:
    x = queue.popleft()
    if x == T:
        if v[x] == "":
            print("0")
        else:
            print(v[T])
        sys.exit()
    for i in mv:
        if i == '*':
            y = x * x
        if i == "+":
            y = x + x
        if i == "-":
            y = x - x
        if i == "/" and x != 0:
            y = x // x
        if y < 0 or y > 10 ** 9:
            continue
        try:
            v[y]
        except:
            v[y] = v[x] + i
            queue.append(y)

print(-1)