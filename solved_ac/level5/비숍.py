N = int(input())

arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
answer = [0, 0]
pos_arr = [[0] * N for _ in range(N)]


def posCheck(i, j):
    # ind = 1
    # while i + ind < N and j + ind < N:
    #     if arr[i + ind][j + ind] == 2:
    #         return False
    #     ind += 1
    ind = 1
    while i - ind >= 0 and j - ind >= 0:
        if arr[i - ind][j - ind] == 2:
            return False
        ind += 1
    # ind = 1
    # while i + ind < N and j - ind >= 0:
    #     if arr[i + ind][j - ind] == 2:
    #         return False
    #     ind += 1
    ind = 1
    while i - ind >= 0 and j + ind < N:
        if arr[i - ind][j + ind] == 2:
            return False
        ind += 1
    return True


def divNBishop(depth, temp):
    for i in range(depth // N, N):
        for j in range(N):
            if not arr[i][j]:
                continue
            if i * N + j <= depth:
                continue
            if depth % 2 != (i * N + j) % 2:
                continue
            if posCheck(i, j):
                arr[i][j] = 2
                answer[depth % 2] = max(temp + 1, answer[depth % 2])
                divNBishop(i * N + j, temp + 1)
                arr[i][j] = 1


divNBishop(-2, 0)
divNBishop(-1, 0)
print(sum(answer))
