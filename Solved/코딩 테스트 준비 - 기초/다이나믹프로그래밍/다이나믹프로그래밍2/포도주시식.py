N = int(input())
dp = [0] * 10001
arr = [0]
for i in range(N) :
  arr.append(int(input()))
dp[1] = arr[1]
dp[2] = arr[2] + arr[1]
dp[3] = max(dp[2], arr[2] + arr[3])
for i in range(4, N) :
  dp[i] = max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i])

print(dp[N])