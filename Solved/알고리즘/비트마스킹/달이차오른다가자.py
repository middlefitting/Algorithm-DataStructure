import math
from collections import deque

if __name__ == "__main__":
    N, M = map(int, input().split())
    arr = []
    queue = deque([])
    answer = math.inf
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    v = [[[0] * 64 for _ in range(M)] for __ in range(N)]
    for i in range(N):
        arr.append(list(str(input())))
    for i in range(N):
        for j in range(M):
            if arr[i][j] == '0':
                queue.append([i, j, 0, 0])
                v[i][j][0] = 1
    while queue:
        x, y, mask, temp = queue.popleft()
        if arr[x][y] == '1':
            answer = temp
            break
        for [mx, my] in mv:
            tx, ty = x + mx, y + my
            if (not 0 <= tx < N) or (not 0 <= ty < M):
                continue
            if v[tx][ty][mask]:
                continue
            if arr[tx][ty] == '.' or arr[tx][ty] == '1' or arr[tx][ty] == '0':
                v[tx][ty][mask] = 1
                queue.append([tx, ty, mask, temp + 1])
            elif ord('a') <= ord(arr[tx][ty]) <= ord('f'):
                v[tx][ty][mask] = 1
                queue.append([tx, ty, mask | 1 << (ord(arr[tx][ty]) - 97), temp + 1])
            elif ord('A') <= ord(arr[tx][ty]) <= ord('F'):
                if mask & (1 << (ord(arr[tx][ty]) - ord('A'))):
                    v[tx][ty][mask] = 1
                    queue.append([tx, ty, mask, temp + 1])

    if answer == math.inf:
        print(-1)
    else:
        print(answer)
