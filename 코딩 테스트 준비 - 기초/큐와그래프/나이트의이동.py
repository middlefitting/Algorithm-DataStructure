import sys
from collections import deque


def bfs(N):
    while (queue):
        x, y = queue.popleft()
        for i in range(8):
            tx, ty = x + dx[i], y + dy[i]
            if ((0 <= tx < N) and (0 <= ty < N) and (arr[tx][ty] == 0)):
                arr[tx][ty] = arr[x][y] + 1
                queue.append([tx, ty])
            if (tx == answer[0] and ty == answer[1]):
                return


T = int(sys.stdin.readline())
dx, dy = [2, 2, -2, -2, 1, -1, 1, -1], [1, -1, 1, -1, 2, 2, -2, -2]

for i in range(T):
    queue = deque([])
    N = int(sys.stdin.readline())
    arr = [[0] * N for _ in range(N)]
    start = list(map(int, sys.stdin.readline().split()))
    arr[start[0]][start[1]] = 1
    queue.append(start)
    answer = list(map(int, sys.stdin.readline().split()))
    bfs(N)
    print(arr[answer[0]][answer[1]] - 1)
