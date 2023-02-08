for _ in range(int(input())):
    N = int(input())
    dp = [0] * (N + 4)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    for i in range(4, N + 1):
        dp[i] = dp[i - 3] + (i // 2) + 1
    print(dp[N])
