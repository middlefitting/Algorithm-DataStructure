dp = [i for i in range(0, 101)]
for i in range(4, 101):
    temp = dp[i - 3]
    for j in range(i, 101):
        dp[j] = max(dp[j], dp[i - 3] + temp * (j - i + 1))
print(dp[int(input())])
