#1일때는 1개의 경우 존재 2일때는 2개의 경우가 추가
N = int(input())
dp = [0] * 1001
dp[1] = 1
dp[2] = 3

for x in range(3, 1001) :
  if (dp[x] != 0) :
    dp[x] = dp[x] % 10007
  else :
    dp[x] = (dp[x - 1] + 2 * dp[x - 2]) % 10007
  
print(dp[N])