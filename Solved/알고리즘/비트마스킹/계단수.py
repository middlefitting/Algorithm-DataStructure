def dfs(num, depth, mask):
    if dp[num][depth][mask] != 0:
        return dp[num][depth][mask]
    if depth == N - 1:
        if mask == 1023:
            return 1
        return 0
    temp, s, b = 0, num - 1, num + 1
    if s >= 0:
        temp += dfs(s, depth + 1, mask | (1 << s))
    if b <= 9:
        temp += dfs(b, depth + 1, mask | (1 << b))
    dp[num][depth][mask] = temp % 1000000000
    return temp


if __name__ == "__main__":
    N = int(input())
    dp = [[[0] * 1024 for _ in range(N)] for _ in range(10)]
    answer = 0
    for i in range(1, 10):
        answer += dfs(i, 0, 1 << i)
        answer = answer % 1000000000
    print(answer)

