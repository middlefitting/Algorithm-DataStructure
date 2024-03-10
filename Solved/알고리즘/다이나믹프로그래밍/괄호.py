dp = [0] * 5001
dp[1] = 1


def fac(n):
    if n == 0:
        return 0
    if dp[n]:
        return dp[n]
    dp[n] = fac(n - 1) * n
    return dp[n]

cp = [0] * 5001
for i in range(1, 5001):
    if i % 2 == 0:
        cp[i] = fac(2 * (i // 2)) // fac(i // 2) // fac((i // 2) + 1) % 1000000007
for i in range(int(input())):
    print(cp[int(input())])
print(cp)
