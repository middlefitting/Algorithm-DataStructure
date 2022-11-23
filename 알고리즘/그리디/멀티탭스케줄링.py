# 2 7
# 2 3 2 3 1 2 7
import math

N, M = map(int, input().split())
arr = list(map(int, input().split()))
concent = [-1] * N
change = 0


def removeConcent(n):
    temp = set()
    d = dict()
    for i in concent:
        if i != -1:
            temp.add(i)

    for i in temp:
        l = 0
        for j in range(n, M):
            l += 1
            if arr[j] == i:
                d[i] = l
                break
            if j == (M - 1):
                l += 1
                d[i] = l
                break
    result = -1
    answer = -1
    for key in d.keys():
        if d[key] >= result:
            answer = key
            result = d[key]
    return answer


for i in range(M):
    if arr[i] in concent:
        continue
    try:
        concent[concent.index(-1)] = arr[i]
    except:
        m = removeConcent(i)
        concent[concent.index(m)] = arr[i]
        change += 1

print(change)


