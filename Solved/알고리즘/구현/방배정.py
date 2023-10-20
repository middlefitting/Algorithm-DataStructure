N, K = map(int, input().split())
d = dict()
arr = [[0, 0] for _ in range(7)]
answer = 0
for _ in range(N):
    gender, grade = map(int, input().split())
    arr[grade][gender] += 1
for i in range(1, 7):
    for j in range(2):
        students = arr[i][j]
        answer += students // K
        if students % K:
            answer += 1
print(answer)