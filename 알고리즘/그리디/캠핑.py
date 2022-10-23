import sys

i = 1
while True:
    answer = 0
    L, P, V = map(int, sys.stdin.readline().split())
    if L == 0 and P == 0 and V == 0:
        break
    answer += (V // P) * L
    answer += min(V % P, L)
    print("Case ", end="")
    print(i, end="")
    print(": ", end="")
    print(answer)
    i += 1
