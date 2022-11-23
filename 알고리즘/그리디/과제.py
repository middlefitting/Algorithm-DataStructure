import sys
제
arr = []
N = int(sys.stdin.readline())
for i in range(N):
    arr.append(list(map(int, sys.stdin.readline().split())))

arr.sort(key=lambda x: x[1], reverse=True)
day = 0
for i in arr:
    day = max(i[0], day)

possible = [0] * day

for i in arr:
    for j in range(i[0]):
        if possible[i[0] - j - 1] == 0:
            possible[i[0] - j - 1] = i[1]
            break

print(sum(possible))