from collections import deque

N, T, G = map(int, input().split())
v = [0] * 100000

queue = deque([])
queue.append(N)
v[N] = 1

while queue:
    x = queue.popleft()
    if x + 1 <= 99999 and v[x + 1] == 0:
        queue.append(x + 1)
        v[x + 1] = v[x] + 1
    if x * 2 <= 99999 and x != 0:
        y = x * 2
        y = y - (1 * (10 ** (len(str(y)) - 1)))
        if v[y] == 0:
            queue.append(y)
            v[y] = v[x] + 1

if v[G] != 0 and v[G] <= T + 1:
    print(v[G] - 1)
else:
    print("ANG")
