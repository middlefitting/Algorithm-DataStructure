N, M = map(int ,input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
pre = [[-1, 0], [-1 ,-1], [0, -1]]
dp = [[0] * M for _ in range(N)]
dp[0][0] = arr[0][0]
for i in range(N):
    for j in range(M):
        temp = arr[i][j]
        for mx, my in pre:
            tx, ty = i + mx, j + my
            if 0 <= tx < N and 0 <= ty < M:
                temp = max(temp, arr[i][j] + dp[tx][ty])
        dp[i][j] = temp
print(dp[N - 1][M - 1])
