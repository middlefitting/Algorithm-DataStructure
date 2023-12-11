def game(a, b):
    if a == b:
        return 1
    if (a == "S" and b == "P") or (a == "P" and b == "R") or (a == "R" and b == "S"):
        return 2
    return 0


N = int(input())
me = list(str(input()))
arr = list()
M = int(input())
for i in range(M):
    arr.append(list(str(input())))

score = 0
for i in range(M):
    for j in range(N):
        score += game(me[j], arr[i][j])
print(score)

answer = 0
for j in range(N):
    temp = 0
    for s in "RSP":
        now = 0
        for i in range(M):
            now += game(s, arr[i][j])
        temp = max(now, temp)
    answer += temp
print(answer)



