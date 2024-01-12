target = list(str(input()))
compare = list(str(input()))
lcs = [[0] * (len(compare) + 1) for _ in range(len(target) + 1)]
answer = 0

for i in range(1, len(target) + 1):
    for j in range(1, len(compare) + 1):
        if target[i - 1] == compare[j - 1]:
            lcs[i][j] = lcs[i - 1][j - 1] + 1
        else:
            lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
        answer = max(answer, lcs[i][j])

print(answer)
