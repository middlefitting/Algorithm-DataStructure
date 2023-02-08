from collections import deque
import sys

M, N = map(int, sys.stdin.readline().split())
arr = [[] for _ in range(N)]
answer = [[10000] * M for _ in range(N)]
queue = deque([])
for i in range(N):
    temp = str(sys.stdin.readline())
    for j in range(M):
        arr[i].append(int(temp[j]))
        if (int(temp[j])):
            answer[i][j] = 0
answer[0][0] = 1
queue.append([0, 0])
dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]


def bfs():
    while (queue):
        x, y = queue.popleft()
        for i in range(4):
            tx, ty = x + dx[i], y + dy[i]
            if ((0 <= tx < N) and (0 <= ty < M) and
                ((arr[tx][ty] == 0) and (answer[tx][ty] > answer[x][y]))):
                answer[tx][ty] = answer[x][y]
                queue.append([tx, ty])
            elif ((0 <= tx < N) and (0 <= ty < M)
                  and ((answer[tx][ty] == 0) or
                       (answer[tx][ty] > answer[x][y] + 1))):
                answer[tx][ty] = answer[x][y] + 1
                queue.append([tx, ty])


bfs()
print(answer[N - 1][M - 1] - 1)
