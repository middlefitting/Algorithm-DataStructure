d = dict()
N = int(input())
M = int(input())
answer = 0
arr = list(map(int, input().split()))
for i in arr:
    try:
        d[i] += 1
    except KeyError:
        d[i] = 1
for i in d.keys():
    target = d.get(M - i, 0)
    if target > 0:
        if (M - i) == i:
            s = d[i] // 2
        else:
            s = min(d[i], d[M - i])
        answer += s
        d[i] -= s
        d[M - i] -= s
print(answer)



