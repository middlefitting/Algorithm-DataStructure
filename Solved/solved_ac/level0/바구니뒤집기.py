N, M = map(int, input().split())
arr = [i for i in range(1, N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    l = (b - a + 1) // 2
    for i in range(a - 1, a - 1 + l):
        temp = arr[i]
        arr[i] = arr[b - 1 - (i - a + 1)]
        arr[b - 1 - (i - a + 1)] = temp
for i in arr:
    print(i, end=" ")
