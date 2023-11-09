N = int(input())


def fac(a, b):
    result = 1
    for i in range(a):
        result *= (b - i)
    for i in range(1, a + 1):
        result //= i
    return result


for i in range(N):
    a, b = map(int, input().split())
    print(fac(a, b))