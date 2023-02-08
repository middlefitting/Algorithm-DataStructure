import sys
from collections import deque

N, M, R = map(int, sys.stdin.readline().split())
arr = []
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))


def one():
    for i in range(N // 2):
        temp = arr[i].copy()
        arr[i] = arr[N - i - 1]
        arr[N - i - 1] = temp
    return N, M


def two():
    for i in range(N):
        for j in range(M // 2):
            temp = arr[i][j]
            arr[i][j] = arr[i][M - j - 1]
            arr[i][M - j - 1] = temp
    return N, M


def three():
    copy = []
    for i in range(N):
        copy.append(arr[i].copy())
    for i in range(N):
        arr.pop()
    for i in range(M):
        arr.append([0] * N)
    for i in range(N):
        for j in range(M):
            arr[j][N - i - 1] = copy[i][j]
    return M, N


def four():
    copy = []
    for i in range(N):
        copy.append(arr[i].copy())
    for i in range(N):
        arr.pop()
    for i in range(M):
        arr.append([0] * N)
    for i in range(N):
        for j in range(M):
            arr[M - 1 - j][i] = copy[i][j]
    return M, N


def separate():
    group1, group2, group3, group4 = [], [], [], []
    for i in range(N):
        if (i < N // 2):
            group1.append(arr[i][:M // 2].copy())
            group2.append(arr[i][M // 2:].copy())
        else:
            group4.append(arr[i][:M // 2].copy())
            group3.append(arr[i][M // 2:].copy())
    return group1, group2, group3, group4


def five():
    group1, group2, group3, group4 = separate()
    for i in range(N // 2):
        for j in range(M):
            if (j < M // 2):
                arr[i][j] = group4[i][j]
            else:
                arr[i][j] = group1[i][j - (M // 2)]
    for i in range(N // 2, N):
        for j in range(M):
            if (j < M // 2):
                arr[i][j] = group3[i - (N // 2)][j]
            else:
                arr[i][j] = group2[i - (N // 2)][j - (M // 2)]
    return N, M


def six():
    group1, group2, group3, group4 = separate()
    for i in range(N // 2):
        for j in range(M):
            if (j < M // 2):
                arr[i][j] = group2[i][j]
            else:
                arr[i][j] = group3[i][j - (M // 2)]
    for i in range(N // 2, N):
        for j in range(M):
            if (j < M // 2):
                arr[i][j] = group1[i - (N // 2)][j]
            else:
                arr[i][j] = group4[i - (N // 2)][j - (M // 2)]
    return N, M


queue = deque(list(map(int, sys.stdin.readline().split())))

f = ["default", "one", "two", "three", "four", "five", "six"]
while (queue):
    method = getattr(sys.modules[__name__], f[queue.popleft()])
    N, M = method()

for i in range(N):
    for j in range(M):
        print(arr[i][j], end=" ")
    print()
