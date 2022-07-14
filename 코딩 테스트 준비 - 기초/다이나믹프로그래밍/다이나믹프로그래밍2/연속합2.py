N = int(input())
arr = list(map(int, input().split()))
dp1 = arr.copy()
dp2 = arr.copy()
dp = [dp1, dp2]

for i in range(1, N) :
  dp[0][i] = max(dp[1][i - 1], dp[0][i - 1] + arr[i])
  dp[1][i] = max(dp[1][i - 1] + arr[i], arr[i])
result = max(dp)

result1 = max(dp[0])
result2 = max(dp[1])
result = max(result1, result2)
print(result)