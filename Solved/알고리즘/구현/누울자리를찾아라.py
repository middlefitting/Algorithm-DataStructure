N = int(input())
arr = [str(input()) for _ in range(N)]

answer = 0
for i in range(N):
    temp = 0
    for j in range(N):
        if arr[i][j] == '.':
            temp += 1
        if arr[i][j] == 'X' or j == N - 1:
            if temp > 1:
                answer += 1
            temp = 0

answer2 = 0
for j in range(N):
    temp = 0
    for i in range(N):
        if arr[i][j] == '.':
            temp += 1
        if arr[i][j] == 'X' or i == N - 1:
            if temp > 1:
                answer2 += 1
            temp = 0
print(answer, answer2)