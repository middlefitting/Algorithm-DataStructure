N = int(input())
arr = list(map(int, input().split()))
arr = [0] + arr
dp = [0] * 1001
for x in range(1, N + 1) :
  i = 1
  answer = arr[x]
  while(x >= i) :
    answer = min(answer, dp[x - i] + arr[i])
    i += 1
  dp[x] = answer

print(dp[N])