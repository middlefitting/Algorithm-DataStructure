dp = [-1] * 56
dp[0] = 0
dp[1] = 1


def pibo(n):
    if n == 0:
        return 0
    if n == 1:
        return 1
    if dp[n] == -1:
        dp[n] = pibo(n - 2) + pibo(n - 1)
    return dp[n]


if __name__ == "__main__":
    print(pibo(int(input())))