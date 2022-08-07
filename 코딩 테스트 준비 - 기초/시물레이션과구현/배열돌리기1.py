import sys

N, M, R = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))
count = min((N // 2) + (N % 2), (M // 2) + (M % 2))
sizeList = []
for i in range(count):
    sizeList.append((N - 2 * i) * 2 + (M - 2 * i) * 2 - 4)


def logic(i, j, n, copy):
    temp_R = R % sizeList[n]
    if (temp_R == 0):
        return
    temp_i = i
    temp_j = j
    while (temp_R > 1):
        if ((i == n) and (j != n)):
            j -= 1
        elif ((i == (N - 1 - n)) and (j != (M - 1 - n))):
            j += 1
        elif ((i != (N - 1 - n)) and (j == n)):
            i += 1
        elif ((i != n) and (j == (M - 1 - n))):
            i -= 1
        temp_R -= 1

    if ((i == n) and (j != n)):
        arr[i][j - 1] = copy[temp_i][temp_j]
    if ((i == (N - 1 - n)) and (j != (M - 1 - n))):
        arr[i][j + 1] = copy[temp_i][temp_j]
    if ((i != (N - 1 - n)) and (j == n)):
        arr[i + 1][j] = copy[temp_i][temp_j]
    if ((i != n) and (j == (M - 1 - n))):
        arr[i - 1][j] = copy[temp_i][temp_j]


def rotation():
    if (R == 0):
        return
    copy = []
    for i in range(N):
        copy.append(arr[i].copy())
    for i in range(N):
        for j in range(M):
            for n in range(count):
                if ((n <= i < N - n) and (n <= j < M - n)
                        and ((i == n) or (i == (N - n - 1)) or (j == n) or
                             (j == (M - n - 1)))):
                    logic(i, j, n, copy)
                    continue


rotation()
for i in range(N):
    for j in range(M):
        print(arr[i][j], end=" ")
    print()
