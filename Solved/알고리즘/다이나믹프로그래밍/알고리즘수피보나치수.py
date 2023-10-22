A = 0
B = 0


def normal(n):
    if n == 1 or n == 2:
        global A
        A += 1
        return 1
    return normal(n - 1) + normal(n - 2)


def dp(n):
    f = [0] * (n + 1)
    f[1] = f[2] = 1
    global B
    for i in range(3, n + 1):
        B += 1
        f[i] = f[i - 1] + f[i - 2]
    return f[n]


if __name__ == "__main__":
    N = int(input())
    normal(N)
    dp(N)
    print(A, B)




