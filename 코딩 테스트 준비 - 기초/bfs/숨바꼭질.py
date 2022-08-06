from collections import deque

N, K = map(int, input().split())
arr = [0] * 100001
arr[N] = 1
queue = deque([])
queue.append(N)
dx = [1, -1, 2]


def bfs():
    while (queue):
        x = queue.popleft()
        for i in range(3):
            if (i < 2):
                tx = x + dx[i]
            else:
                tx = x * dx[i]
            if ((0 <= tx <= 100000) and arr[tx] == 0):
                arr[tx] = arr[x] + 1
                queue.append(tx)
            if (tx == K):
                return


bfs()
print(arr[K] - 1)
