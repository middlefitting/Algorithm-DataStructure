N, M = map(int, input().split())
target = M * N
arr = list(map(int, input().split()))
for n in arr:
    print(n - target, end = " ")
