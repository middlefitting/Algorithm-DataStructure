N, P, Q = map(int, input().split())
dp = dict()
dp[0] = 1


def dfs(x):
    if dp.get(x):
        return dp.get(x)
    dp[x] = dfs(x // P) + dfs(x // Q)
    return dp[x]


print(dfs(N))
