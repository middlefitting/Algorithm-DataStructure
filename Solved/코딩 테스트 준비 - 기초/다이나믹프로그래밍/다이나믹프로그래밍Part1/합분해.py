N, K = map(int, input().split())
dp = [[0] * (N + 1) for _ in range(K + 1)]
for i in range(N + 1) :
  dp[1][i] = 1

for k in range(1, K + 1) :
  for n in range(N + 1) :
    for L in range(n + 1) :
      dp[k][n] += dp[k - 1][n - L]

print(dp[K][N] % 1000000000)