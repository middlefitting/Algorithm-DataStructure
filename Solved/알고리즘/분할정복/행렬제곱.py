N, B = map(int, input().split())


def procession_mul(a, b):
    result = [[0] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            for k in range(N):
                result[i][j] += a[i][k] * b[k][j]
                result[i][j] %= 1000
    return result


def divide_conquer(mat, n):
    if n == 1:
        return mat
    elif n % 2:
        return procession_mul(divide_conquer(mat, n - 1), mat)
    else:
        temp = divide_conquer(mat, n // 2)
        return procession_mul(temp, temp)


if __name__ == "__main__":
    A = []
    for _ in range(N):
        A.append(list(map(int, input().split())))

    result = divide_conquer(A, B)
    for i in range(N):
        for j in range(N):
            result[i][j] %= 1000
            print(result[i][j], end=" ")
        print()
