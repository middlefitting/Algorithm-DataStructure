flag = False
arr = list()
for i in range(7):
    temp = int(input())
    if temp %2 == 1:
        flag = True
        arr.append(temp)
if flag:
    print(sum(arr))
    print(min(arr))
else:
    print(-1)