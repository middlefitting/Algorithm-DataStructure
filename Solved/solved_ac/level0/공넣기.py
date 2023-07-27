N, M = map(int, input().split())
arr = [0] * N
for _ in range(M):
    a, b, t = map(int, input().split())
    for i in range(a - 1, b):
        arr[i] = t
for i in arr:
    print(i, end=" ")