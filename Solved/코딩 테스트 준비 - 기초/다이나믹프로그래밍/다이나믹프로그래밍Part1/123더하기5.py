dp = [[0] * 4 for _ in range(100001)]
dp[1][1] = 1

dp[2][2] = 1

dp[3][1] = 1
dp[3][2] = 1
dp[3][3] = 1
for x in range(4, 100001) :
  dp[x][1] = (dp[x - 1][2] + dp[x - 1][3]) % 1000000009 
  dp[x][2] = (dp[x - 2][1] + dp[x - 2][3]) % 1000000009 
  dp[x][3] = (dp[x - 3][1] + dp[x - 3][2]) % 1000000009 

N = int(input())
for i in range(N) :
  temp = int(input())
  print(sum(dp[temp]) % 1000000009)