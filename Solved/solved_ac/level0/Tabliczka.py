N, M = map(int, input().split())

if N % 2 == 0 or M % 2 == 0:
    print(0)
else:
    print(min(N, M))

