import sys
sys.setrecursionlimit(10**5)
N = int(input())
arr = []
dp = [[0] * N for _ in range(N)]
dp2 = [[0] * N for _ in range(N)]
normal = 0
greenGuy = 0
mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
for i in range(N):
    arr.append(list(str(input())))


def dfs(i, j, color):
    if dp[i][j]:
        return
    dp[i][j] = 1
    for [dx, dy] in mv:
        tX = dx + i
        tY = dy + j
        if 0 <= tX < N and 0 <= tY < N:
            if arr[tX][tY] == color:
                dfs(tX, tY, color)


def dfs2(i, j, color):
    if dp2[i][j]:
        return
    dp2[i][j] = 1
    for [dx, dy] in mv:
        tX = dx + i
        tY = dy + j
        if 0 <= tX < N and 0 <= tY < N:
            if color == "B" and arr[tX][tY] == color:
                dfs2(tX, tY, color)
            elif (color == 'R' or color == 'G') and (arr[tX][tY] == 'R' or arr[tX][tY] == 'G'):
                dfs2(tX, tY, color)


for i in range(N):
    for j in range(N):
        if not dp[i][j]:
            dfs(i, j, arr[i][j])
            normal += 1
        if not dp2[i][j]:
            dfs2(i, j, arr[i][j])
            greenGuy += 1
print(normal, greenGuy)