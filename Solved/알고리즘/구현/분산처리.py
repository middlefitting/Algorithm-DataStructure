def next_num(n, mul_num, dp):
    if n == 10:
        n = 0
    if dp[n] < 0:
        tmp = (n * mul_num) % 10
        if tmp == 0:
            dp[n] = 10
        else:
            dp[n] = tmp
        return dp[n]
    return dp[n]


if __name__ == "__main__":
    for _ in range(int(input())):
        dp = [-1] * 10
        mul_num, count = map(int, input().split())
        n = 1
        for i in range(count):
            n = next_num(n, mul_num, dp)
        print(n)
