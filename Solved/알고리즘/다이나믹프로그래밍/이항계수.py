N, K = map(int, input().split())
dp = [0] * (N + 1)


def factorial(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result


def ncr(n, k):
    return dp[n] // (dp[k] * dp[n - k])


for i in range(N + 1):
    dp[i] = factorial(i)

print(ncr(N, K) % 10007)
