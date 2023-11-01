N, M = map(int, input().split())

answer = ""
num = 0
every = [dict() for _ in range(M)]
for i in range(N):
    temp = str(input())
    for j in range(M):
        try:
            every[j][temp[j]] += 1
        except KeyError:
            every[j][temp[j]] = 1
for i in range(M):
    d = every[i]
    count = 0
    alpha = 'Z'
    for key, value in d.items():
        if value > count:
            count = value
            alpha = key
        elif value == count:
            if ord(alpha) > ord(key):
                alpha = key
    answer += alpha
    num += N - count
print(answer)
print(num)
