s1 = list(str(input()))
s2 = list(str(input()))

dp = [[0] * (len(s1) + 1) for _ in range(len(s2) + 1)]
answer = [0, 0]
for i in range(1, len(s2) + 1):
    for j in range(1, len(s1) + 1):
        if s2[i - 1] == s1[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        if dp[i][j] > dp[answer[0]][answer[1]]:
            answer = [i, j]

print(dp[answer[0]][answer[1]])
result = ""
while answer[0] > 0 or answer[1] > 0:
    if answer[0] > 0:
        if dp[answer[0] - 1][answer[1]] == dp[answer[0]][answer[1]]:
            answer = [answer[0] - 1, answer[1]]
            continue
    if answer[1] > 0:
        if dp[answer[0]][answer[1] - 1] == dp[answer[0]][answer[1]]:
            answer = [answer[0], answer[1] - 1]
            continue
    result = s2[answer[0] - 1] + result
    answer = [answer[0] - 1, answer[1] - 1]
print(result)

