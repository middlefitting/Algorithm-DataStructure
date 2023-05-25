N, M = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(str(input())))
for i in range(N):
    for j in range(M):
        print(arr[i][M - j - 1], end="")
    print()
