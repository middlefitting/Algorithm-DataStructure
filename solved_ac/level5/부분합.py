import sys

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
answer = []

temp = 0
s = -1
e = -1

while True:
    if e == N:
        s += 1
        if s < N:
            temp -= arr[s]
        else:
            break
    elif temp <= S:
        e += 1
        if e < N:
            temp += arr[e]
    elif temp >= S:
        s += 1
        if s < N:
            temp -= arr[s]
    if temp >= S:
        answer.append(e - s)

if len(answer) == 0:
    print(0)
else:
    print(min(answer))
