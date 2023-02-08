import sys
from collections import deque

sys.setrecursionlimit(10**5)
N, K = map(int, input().split())
arr = [0] * 100001
arr[N] = 1
queue = deque([])
queue.append(N)
queue2 = deque([])
queue2.append(N)
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


def dfs(x, depth):
    if (x == K):
        for i in (queue2):
            print(i, end=" ")
        print()
        exit(0)
    for i in range(3):
        if (i < 2):
            tx = x + dx[i]
        else:
            tx = x * dx[i]
        if ((0 <= tx <= 100000) and (arr[tx] == depth + 1)):
            arr[tx] = arr[x] + 1
            queue2.append(tx)
            dfs(tx, depth + 1)
            queue2.pop()


bfs()
print(arr[K] - 1)
dfs(N, 1)
