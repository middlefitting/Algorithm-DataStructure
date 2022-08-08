import sys

from collections import deque


def bfs():
    answer = 0
    for i in range(N[0]):
        for j in range(M[0]):
            if (arr[i][j]):
                answer += 1
                queue.append([i, j])
                while (queue):
                    x, y = queue.popleft()
                    for n in range(4):
                        tx = x + dx[n]
                        ty = y + dy[n]
                        if ((0 <= tx < N[0]) and (0 <= ty < M[0])
                                and (arr[tx][ty])):
                            arr[tx][ty] = 0
                            queue.append([tx, ty])
    print(answer)


T = int(sys.stdin.readline())
dx, dy = [1, 0, -1, 0], [0, 1, 0, -1]
queue = deque([])
for _ in range(T):
    M = [0]
    N = [0]
    M[0], N[0], K = map(int, sys.stdin.readline().split())
    arr = [[0] * M[0] for _ in range(N[0])]
    for _ in range(K):
        j, i = map(int, sys.stdin.readline().split())
        arr[i][j] = 1
    bfs()
