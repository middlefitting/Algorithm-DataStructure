N, K = map(int, input().split())
dp = [0] * (N + 1)


def factorial(n):
    if n == 0 or n == 1:
        return 1
    if dp[n]:
        return dp[n]
    else:
        return factorial(n - 1) * n


def ncr(n, k):
    return factorial(n) // (factorial(k) * factorial(n - K))


print(ncr(N, K) % 10007)
