T = int(input())


def make_arr(arr, N, X):
    for i in range(N):
        for j in range(i, N):
            if i == j:
                arr[i][j] = X[i]
            else:
                arr[i][j] = X[j] + arr[i][j - 1]


def make_dict(dict, arr):
    for i in range(N):
        for j in range(i, N):
            try:
                dict[arr[i][j]] += 1
            except:
                dict[arr[i][j]] = 1


def find_answer(dict, arr):
    answer = 0
    for i in range(M):
        for j in range(i, M):
            temp = T - arr[i][j]
            try:
                answer += dict[temp]
            except:
                continue
    return answer


N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))
arrA = [[0] * N for _ in range(N)]
arrB = [[0] * M for _ in range(M)]
dictA = dict()
make_arr(arrA, N, A)
make_arr(arrB, M, B)
make_dict(dictA, arrA)
print(find_answer(dictA, arrB))
