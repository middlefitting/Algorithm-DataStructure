N, M, X, Y = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N + X)]
for i in range(N + X):
    for j in range(M + Y):
        if 0 <= i - X < N and 0 <= j - Y < M:
            arr[i][j] -= arr[i - X][j - Y]

for i in range(N):
    for j in range(M):
        print(arr[i][j], end=" ")
    print("")