import sys
sys.setrecursionlimit(10**5)
mv = [[1, 0], [-1, 0], [0, 1], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]


def dfs(x, y):
    for mx, my in mv:
        tx, ty = x + mx, y + my
        if 0 <= tx < N and 0 <= ty < M:
            if (not v[tx][ty]) and (arr[tx][ty] != 0):
                v[tx][ty] = 1
                dfs(tx, ty)


if __name__ == "__main__":
    while True:
        M, N = map(int, input().split())
        arr = [list(map(int, input().split())) for _ in range(N)]
        v = [[0] * M for _ in range(N)]
        answer = 0

        if M == 0 and N == 0:
            break

        for i in range(N):
            for j in range(M):
                if arr[i][j] == 0:
                    continue
                if v[i][j]:
                    continue
                answer += 1
                dfs(i, j)
        print(answer)
