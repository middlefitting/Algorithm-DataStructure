N, M = map(int, input().split())
arr = [i for i in range(1, N + 1)]
for i in range(M):
    a, b = map(int, input().split())
    a, b = a - 1, b - 1
    temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
for i in range(N):
    print(arr[i], end=" ")

