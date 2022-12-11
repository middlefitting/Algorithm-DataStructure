N = int(input())
arr = list(map(int, input().split()))
Num = int(input())
d = dict()
for i in range(N):
    try:
        d[arr[i]] += 1
    except:
        d[arr[i]] = 1

print(d[Num])
