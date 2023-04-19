import sys
sys.setrecursionlimit(10**5)


def dfs(x, y, target, pmx, pmy):
    v[x][y] = 1
    for mx, my in mv:
        tx, ty = mx + x, my + y
        if mx == -1 * pmx and my == -1 * pmy:
            continue
        if 0 <= tx < N and 0 <= ty < M:
            if arr[tx][ty] == target:
                if v[tx][ty]:
                    answer[0] = 1
                    continue
                dfs(tx, ty, target, mx, my)


if __name__== "__main__":
    N, M = map(int, input().split())
    arr = [list(str(input())) for _ in range(N)]
    f = [[0] * M for _ in range(N)]
    answer = [0]
    mv = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    for i in range(N):
        for j in range(M):
            if f[i][j]:
                continue
            v = [[0] * M for _ in range(N)]
            if answer[0]:
                continue
            dfs(i, j, arr[i][j], 0, 0)
            for x in range(N):
                for y in range(M):
                    if v[x][y]:
                        f[i][j] = 1
    if answer[0]:
        print("Yes")
    else:
        print("No")
