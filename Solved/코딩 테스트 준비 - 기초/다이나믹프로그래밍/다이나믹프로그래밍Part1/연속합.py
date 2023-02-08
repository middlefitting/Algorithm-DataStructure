N = int(input())
dp = list(map(int , input().split()))
result = dp[0]
for i in range(1, N) :
  if (dp[i - 1] > 0 and (dp[i -1] + dp[i]) > 0) :
    dp[i] = dp[i - 1] + dp[i]
  result = max(dp[i], result)
print(result)