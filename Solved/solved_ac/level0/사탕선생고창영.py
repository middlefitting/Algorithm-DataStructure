import sys

for _ in range(int(sys.stdin.readline())):
    str(sys.stdin.readline())
    answer = 0
    n = int(sys.stdin.readline())
    for i in range(n):
        answer += (int(sys.stdin.readline())) % n
        answer %= n
    if answer == 0:
        print("YES")
    else:
        print("NO")

