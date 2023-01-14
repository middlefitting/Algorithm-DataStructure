import sys

S, M = map(int, input().split())
for i in range(S + 1):
    j = S - i
    if abs(i - j) == M:
        print(max(i, j), min(i, j))
        sys.exit()
print(-1)