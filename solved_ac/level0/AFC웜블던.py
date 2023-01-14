import sys

S, M = map(int, input().split())
for i in range(S):
    j = S - i
    if abs(i - j) == M:
        if i >= j:
            print(i, j)
        else:
            print(j, i)
        sys.exit()
print(-1)