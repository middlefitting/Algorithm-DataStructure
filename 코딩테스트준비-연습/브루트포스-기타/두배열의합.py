T = int(input())
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
answer = 0
arrA = [[0] * N for _ in range(N)]
arrB = [[0] * M for _ in range(M)]
dictA = dict()
for i in range(N):
    for j in range(i, N):
        if i == j:
            arrA[i][j] = A[i]
        else:
            arrA[i][j] = A[j] + arrA[i][j - 1]
for i in range(M):
    for j in range(i, M):
        if i == j:
            arrB[i][j] = B[i]
        else:
            arrB[i][j] = B[j] + arrB[i][j - 1]
for i in range(N):
    for j in range(i, N):
        try:
            dictA[arrA[i][j]] += 1
        except:
            dictA[arrA[i][j]] = 1
for i in range(M):
    for j in range(i, M):
        temp = T - arrB[i][j]
        try:
            answer += dictA[temp]
        except:
            continue
print(answer)
