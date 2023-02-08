dp = [0] * 11
dp[1] = 1
dp[2] = 2
dp[3] = 4

for x in range(4, 11) :
  dp[x] = dp[x - 1] + dp[x - 2] + dp[x - 3]

N = int(input())
for i in range(N) :
  temp = int(input())
  print(dp[temp])