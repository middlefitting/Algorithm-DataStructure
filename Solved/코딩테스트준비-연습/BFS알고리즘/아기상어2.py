from collections import deque

N, M = map(int, input().split())
arr = [list(map(int , input().split())) for _ in range(N)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]
answer = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            queue = deque([[i, j, 0]])
            v = [[0] * M for _ in range(N)]
            while queue:
                x, y, depth = queue.popleft()
                if arr[x][y] == 1:
                    answer = max(answer, depth)
                    break
                for mx, my in mv:
                    tx, ty = x + mx, y + my
                    if 0 <= tx < N and 0 <= ty < M:
                        if v[tx][ty] == 0:
                            v[tx][ty] = 1
                            queue.append([tx, ty, depth + 1])
print(answer)
