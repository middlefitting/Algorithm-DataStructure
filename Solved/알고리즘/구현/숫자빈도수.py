d = dict()
for i in "0123456789":
    d[i] = 0
N, D = map(int, input().split())
for i in range(1, N + 1):
    for s in str(i):
        d[s] += 1
print(d[str(D)])
