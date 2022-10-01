import sys

N = int(sys.stdin.readline())
result = 1000 * 1000
rgb_distance = []
for i in range(N):
    rgb_distance.append(list(map(int, sys.stdin.readline().split())))

for i in range(3):
    dp = [[1000 * 1000] * 3 for _ in range(N)]
    dp[0][i] = rgb_distance[0][i]
    for j in range(1, N):
        dp[j][0] = min(dp[j - 1][1], dp[j - 1][2]) + rgb_distance[j][0]
        dp[j][1] = min(dp[j - 1][2], dp[j - 1][0]) + rgb_distance[j][1]
        dp[j][2] = min(dp[j - 1][0], dp[j - 1][1]) + rgb_distance[j][2]
    for j in range(3):
        if i != j:
            result = min(result, dp[N - 1][j])

print(result)
