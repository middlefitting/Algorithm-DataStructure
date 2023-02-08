T = int(input())
dp = [0] * 1000001
dp[1] = 1
dp[2] = 2
dp[3] = 4
for i in range(T) :
  N = int(input())
  for j in range(4, N + 1) :
    if(dp[j] == 0):
      dp[j] = (dp[j - 1] + dp[j - 2] + dp[j -3]) % 1000000009
  print(dp[N])