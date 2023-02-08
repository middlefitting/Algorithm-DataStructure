N = int(input())
temp = int(N ** 0.5)
dp = [0] * (N + 1)
for i in range(1, N + 1) :
  dp[i] = i

for i in range(2, N + 1) :
  for j in range(1, int(i ** 0.5) + 1) :
    dp[i] = min(dp[i], dp[i - j*j] + 1)
print(dp[N])
