from collections import deque

M, N = map(int, input().split())
arr = [[[[0] * 2 for _ in range(2)] for _ in range(M)] for _ in range(N)]
answer = 0
room_size = set()
d = dict()
v = [[0] * M for _ in range(N)]
mv = [[1, 0, 0, 1], [-1, 0, 0, 0], [0, 1, 1, 1], [0, -1, 1, 0]]
room_count = 0


def find_wall(i, j, loc):
    temp = loc
    if temp >= 8:
        temp -= 8
        arr[i][j][0][1] = 1
    if temp >= 4:
        temp -= 4
        arr[i][j][1][1] = 1
    if temp >= 2:
        temp -= 2
        arr[i][j][0][0] = 1
    if temp >= 1:
        temp -= 1
        arr[i][j][1][0] = 1


def max_bfs(i, j):
    visit = [[0] * M for _ in range(N)]
    visit[i][j] = 1
    queue = deque([[i, j]])
    naver = set()
    size = 1
    naver_arr = []
    while queue:
        x, y = queue.popleft()
        for mx, my, wx, wy in mv:
            tx, ty = x + mx, y + my
            if 0 <= tx < N and 0 <= ty < M:
                if arr[x][y][wx][wy] == 1:
                    naver_arr.append([tx, ty])
                    continue
                if visit[tx][ty] != 0:
                    continue
                visit[tx][ty] = 1
                size += 1
                queue.append([tx, ty])
    for p, q in naver_arr:
        if visit[p][q] == 0:
            naver.add(d[p * M + q])
    return size + max(naver)


def find_room_bfs(i, j):
    trr = [i * M + j]
    if v[i][j] != 0:
        return 0
    v[i][j] = 1
    queue = deque([[i, j]])
    size = 1
    while queue:
        x, y = queue.popleft()
        for mx, my, wx, wy in mv:
            tx, ty = x + mx, y + my
            if 0 <= tx < N and 0 <= ty < M:
                if arr[x][y][wx][wy] == 1:
                    continue
                if v[tx][ty] != 0:
                    continue
                trr.append(tx * M + ty)
                v[tx][ty] = 1
                size += 1
                queue.append([tx, ty])
    room_size.add(size)
    for t in trr:
        d[t] = size
    return 1


for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(M):
        find_wall(i, j, temp[j])
for i in range(N):
    for j in range(M):
        room_count += find_room_bfs(i, j)
for i in range(N):
    for j in range(M):
        answer = max(answer, max_bfs(i, j))
print(room_count)
print(max(room_size))
print(answer)