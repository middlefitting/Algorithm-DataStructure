from collections import deque

N, M, K = map(int, input().split())
v = [[[None] * (K + 1) for _ in range(M)] for __ in range(N)]
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
# arr = []
# for i in range(N):
#     arr.append([])
#     t = list(str(input()))
#     for j in range(M):
#         arr[i].append(int(t[j]))
arr = [list(map(int, input().strip())) for _ in range(N)]
queue = deque([])
# queue = deque([[0, 0, K]])


def dfs():
    queue.append([0, 0, K])
    v[0][0][K] = 1
    while queue:
        x, y, z = queue.popleft()
        if x == (N - 1) and y == (M - 1):
            return v[x][y][z]
        for i in mv:
            tx, ty = x + i[0], y + i[1]
            if 0 <= tx < N and 0 <= ty < M:
                if arr[tx][ty] == 1 and z > 0 and v[tx][ty][z - 1] is None:
                    queue.append([tx, ty, z - 1])
                    v[tx][ty][z - 1] = v[x][y][z] + 1
                elif arr[tx][ty] == 0 and v[tx][ty][z] is None:
                    queue.append([tx, ty, z])
                    v[tx][ty][z] = v[x][y][z] + 1
    return -1


print(dfs())


# def bfs() :
#     queue.append([0,0,K])
#     v[0][0][K] = 1
#     while queue :
#         x, y, z = queue.popleft()
#         if x == N-1 and y == M - 1:
#             return v[x][y][z]
#         for i in mv:
#             nx, ny = i[0] + x, i[1]+y
#             if 0 <= nx < N and 0 <= ny < M:
#                 if arr[nx][ny] == 1 and z > 0 and v[nx][ny][z-1] is None:
#                     v[nx][ny][z-1] = v[x][y][z] + 1
#                     queue.append([nx, ny, z-1])
#                 elif arr[nx][ny] == 0 and v[nx][ny][z] is None:
#                     v[nx][ny][z] = v[x][y][z] + 1
#                     queue.append([nx, ny, z])
#     return -1
#
#
# print(bfs())
