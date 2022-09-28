import sys

A, B, C = map(int, sys.stdin.readline().split())


def divconquer(A, B, C):
    if B == 1:
        return A % C
    temp = divconquer(A, B // 2, C)
    if B % 2 == 1:
        return temp * temp * A % C
    else:
        return temp * temp % C


print(divconquer(A, B, C))
