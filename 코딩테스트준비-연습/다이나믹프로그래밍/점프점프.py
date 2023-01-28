N = int(input())
dp = [0] * N
arr = list(map(int, input().split()))
find = [False]


def dfs(temp, depth):
    if temp == (N - 1):
        find[0] = True
        return
    mv = arr[temp]
    for i in range(1, mv + 1):
        if (i + temp) >= N:
            break
        if dp[temp + i] == 0:
            dp[temp + i] = depth + 1
            dfs(temp + i, depth + 1)
        else:
            if dp[temp + i] > (depth + 1):
                dp[temp + i] = depth + 1
                dfs(temp + i, depth + 1)


dfs(0, 0)
if find[0]:
    print(dp[N - 1])
else:
    print(-1)

