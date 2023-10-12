N = int(input())
arr = [str(input()) for _ in range(N)]
for i in range(len(arr[0])):
    flag = True
    for j in range(N):
        if arr[0][i] != arr[j][i]:
            flag = False
    if flag:
        print(arr[0][i], end="")
    else:
        print("?", end="")
