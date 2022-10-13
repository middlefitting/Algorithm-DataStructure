# 잘 생각해 보면 B가 짝수일 때 A^B는 A^(B/2)의 제곱입니다. B가 홀수일 때는 A^(B/2)*A이고요.

A, B, C = map(int, input().split())


def divConquer(A, B, C):
    if B == 2:
        return A ** B % C
    if B == 1:
        return A % C
    if B % 2 == 0:
        return divConquer(A, B//2, C)**2 % C
    return divConquer(A, B//2, C)**2 * A % C


print(divConquer(A, B, C))