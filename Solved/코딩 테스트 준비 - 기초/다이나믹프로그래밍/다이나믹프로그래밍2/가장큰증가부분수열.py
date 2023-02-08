N = int(input())
arr = list(map(int, input().split()))
dp = arr.copy()
for i in range(N):
  for j in range(i) :
    if (arr[j] < arr[i]) :
      if (dp[i] < arr[i] + dp[j]) :
        dp[i] = arr[i] + dp[j]
print(max(dp))