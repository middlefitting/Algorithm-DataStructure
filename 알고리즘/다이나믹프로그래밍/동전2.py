import math
N, K = map(int, input().split())
arr = [math.inf] * 100001
dp = [0] * 100001
coins = []
for i in range(N):
    temp = int(input())
    coins.append(temp)
    dp[temp] = 1
    arr[temp] = 1

for i in range(1, K + 1):
    possile = []
    for coin in coins:
        if (i - coin > 0) and dp[i - coin]:
            dp[i] = 1
            arr[i] = min(arr[i], arr[i - coin] + 1)

if not dp[K]:
    print(-1)
else:
    print(arr[K])
