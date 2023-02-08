N, r, c = map(int, input().split())

r += 1
c += 1
answer = 0
while (N > 0):
    temp = 2**N
    if (r > (temp / 2)):
        answer += ((temp / 2)**2 * 2)
        r -= temp / 2
    if (c > (temp / 2)):
        answer += (temp / 2)**2
        c -= temp / 2
    N -= 1

print(int(answer))