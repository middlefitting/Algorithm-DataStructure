search = [[0, -1], [-1, 0], [0, 1], [1, 0]]
turn = [3, 0, 1, 2]
back = [[1, 0], [0, -1], [-1, 0], [0, 1]]
N, M = map(int, input().split())
r, c, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = [0]


def dfs(x, y, d):
    if arr[x][y] == 0:
        arr[x][y] = 2
        answer[0] += 1
    for _ in range(4):
        mx, my = search[d]
        tx, ty = mx + x, my + y
        d = turn[d]
        if arr[tx][ty] == 0:
            dfs(tx, ty, d)
            return
    mx, my = back[d]
    tx, ty = mx + x, my + y
    if arr[tx][ty] != 1:
        dfs(tx, ty, d)


dfs(r, c, d)
print(answer[0])