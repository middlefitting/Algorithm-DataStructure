N = int(input())
arr = [[100000000] * N for _ in range(N)]
vector = [[] for _ in range(N)]
for _ in range(N):
    temp = list(map(int, input().split()))
    for i in range(1, (len(temp) // 2)):
        vector[temp[0] - 1].append(temp[i * 2 - 1] - 1)
        vector[temp[i * 2 - 1] - 1].append(temp[0] - 1)
        arr[temp[0] - 1][temp[i * 2 - 1] - 1] = temp[i * 2]
        arr[temp[i * 2 - 1] - 1][temp[0] - 1] = temp[i * 2]

for i in range(N):
    arr[i][i] = 0

for i in range(N):
    for j in (vector[i]):
        for n in range(N):
            arr[i][n] = min(arr[i][n], arr[i][j] + arr[j][n])
            arr[n][i] = min(arr[i][n], arr[i][j] + arr[j][n])
answer = 0
print(arr)
for i in range(N):
    answer = max(answer, max(arr[i]))
print(answer)
