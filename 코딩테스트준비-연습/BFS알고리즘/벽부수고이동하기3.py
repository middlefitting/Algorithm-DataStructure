import sys
from collections import deque

N, M, K = map(int, input().split())
v = [[K + 1] * M for __ in range(N)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
arr = [list(map(int, input().strip())) for _ in range(N)]
queue = deque([])
queue.append([0, 0, 0])
v[0][0] = 1
m = True
answer = 1
while queue:
    q_len = len(queue)
    for _ in range(q_len):
        x, y, z = queue.popleft()
        if x == (N - 1) and y == (M - 1):
            print(answer)
            exit()
        for mx, my in mv:
            tx, ty = x + mx, y + my
            if not (0 <= tx < N and 0 <= ty < M):
                continue
            if z >= v[tx][ty]:
                continue
            if arr[tx][ty] == 1 and v[tx][ty] > z and m:
                queue.append([tx, ty, z + 1])
                v[tx][ty] = z
            if arr[tx][ty] == 1 and v[tx][ty] > z and not m:
                queue.append([x, y, z])
            elif arr[tx][ty] == 0 and v[tx][ty] > z:
                queue.append([tx, ty, z])
                v[tx][ty] = z
    m = not m
    answer += 1
print(-1)
