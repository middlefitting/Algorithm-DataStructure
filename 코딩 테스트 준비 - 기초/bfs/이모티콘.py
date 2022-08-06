from collections import deque

N = int(input())
arr = [0] * 1001
arr[1] = 1
queue = deque([])
queue.append(1)
dx = [-1, 2]


def bfs():
    while (queue):
        x = queue.popleft()
        for i in range(3):
            if (i == 0):
                tx = x + dx[i]
                if ((0 <= tx <= 1000)
                        and ((arr[tx] == 0) or arr[tx] > arr[x] + 1)):
                    arr[tx] = arr[x] + 1
                    queue.append(tx)
            if (i == 2):
                j = 2
                while (True):
                    tx = x * j
                    if ((0 <= tx <= 1000)
                            and ((arr[tx] == 0) or arr[tx] > arr[x] + j)):
                        arr[tx] = arr[x] + j
                        queue.append(tx)
                    j += 1
                    if (tx > 1000 or tx == 0):
                        break


bfs()
print(arr[N] - 1)
