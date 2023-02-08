# (r, c)
# 라면, (r - 2, c - 1), (r - 2, c + 1), (r, c - 2), (r, c + 2), (r + 2, c - 1), (r + 2, c + 1)

from collections import deque

N = int(input())
start = [0, 0]
end = [0, 0]
a, b, c, d = map(int, input().split())
start = [a, b]
end = [c, d]
mv = [[-2, -1], [-2, 1], [0, -2], [0, 2], [2, -1], [2, 1]]
queue = deque([])
queue.append([start, 0])
answer = -1
v = [[0] * N for _ in range(N)]
v[start[0]][start[1]] = 1

while queue:
    x, temp = queue.popleft()
    if x[0] == end[0] and x[1] == end[1]:
        answer = temp
        break
    for dx, dy in mv:
        y = [x[0] + dx, x[1] + dy]
        if 0 <= y[0] < N  and 0 <= y[1] < N:
            if v[y[0]][y[1]] == 0:
                v[y[0]][y[1]] = 1
                queue.append([y, temp + 1])
print(answer)
