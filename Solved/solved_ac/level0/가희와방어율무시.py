N, M = map(int, input().split())
if N / 100 * (100 - M) >= 100:
    print(0)
else:
    print(1)
