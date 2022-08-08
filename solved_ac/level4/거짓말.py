M, N = map(int, input().split())

knowlist = list(map(int, input().split()))
knowlist.pop(0)
know = set(knowlist)
lie = [1] * N

arr = []
for i in range(N):
    temp = list(map(int, input().split()))
    temp.pop(0)
    arr.append(temp)

while (1):
    copy = lie.copy()
    for i in range(N):
        for j in range(len(arr[i])):
            if (arr[i][j] in know):
                lie[i] = 0
                for k in range(len(arr[i])):
                    know.add(arr[i][k])
                continue
    if (sum(copy) == sum(lie)):
        print(sum(lie))
        break
