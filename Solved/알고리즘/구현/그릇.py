s = str(input())

answer = 0
for i in range(len(s)):
    if i == 0:
        answer += 10
    elif s[i] == s[i - 1]:
        answer += 5
    else:
        answer += 10
print(answer)
